package ua.com.dbncalc.steel.services.util;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import ua.com.dbncalc.steel.dto.ColComprWithBuckDto;
import ua.com.dbncalc.steel.models.sections.Section;
import ua.com.dbncalc.steel.models.sections.ShapedSection;
import ua.com.dbncalc.steel.models.sections.WeldedIBeamSection;
import ua.com.dbncalc.steel.models.steels.Steel;
import ua.com.dbncalc.steel.repositories.*;
import ua.com.dbncalc.steel.services.Table8_1Entity;

import java.util.Map;

import static java.lang.Math.sqrt;
@NoArgsConstructor
@Getter
@Setter
//@Component
public class ColComprWithBuckCalcUnit {

    private ColComprWithBuckDto input;
    // TODO: 03.05.2021 change to section
    private Section section;

    private Steel steel;
    // TODO: 04.05.2021 replace the different repositories of sections by one table of sections
    // TODO: 04.05.2021 Implement calculation geom props for welded I-beam
    @Autowired
    private SectionRepository sectionRepository;

    // TODO: realize calculation for Z axis

    @Autowired
    private SteelRepository steelRepository;

    //effective length Y axis (lefY) in m
    private Double effectiveLengthY;

    //slenderness Y axis (lambdaY)
    private Double slendernessY;

    //non dimensional slenderness Y axis (overline lambdaY)
    private Double nonDimSlendernessY;

    //TODO: implement choosing strange depending on shaped profile or from plates
    //design yield strange (Ry) in N/mm^2
    private Double designYieldStrange;

        // TODO : realize conditional initialization
//    {
//        if (input.getSection() instanceof WeldedIBeamSection)
//                ?
//
//    }

    //steel modulus of elasticity (E) in MPa - megapascal
    private static Double modulusOfElasticity = 2.06e5;

    public void calculate(ColComprWithBuckDto input) {
        this.input = input;
//        this.input.getSection().setNumber(this.input.getSectionNumber());
        loadSteelData();
        loadSectionData();
        calculateEffectiveLengthY();
        calculateSlendernessY();
        calculateNonDimSlendernessY();
        calculateDeltaModulusY();
        calculateBucklingModulusY();
        calculateColComprWithBuckModulusY();
    }

    private enum TypeOfSlenderCurve{
        A,
        B,
        C
    }

    //table 8.1 of dbn2.6-198:2014
    // TODO : think about realisation in db
    private static Map<TypeOfSlenderCurve, Table8_1Entity> AlphaAndBetaCoefficients = Map.of(
            TypeOfSlenderCurve.A, new Table8_1Entity(0.03, 0.06),
            TypeOfSlenderCurve.B, new Table8_1Entity(0.04, 0.09),
            TypeOfSlenderCurve.C, new Table8_1Entity(0.04, 0.14)
            );
    //TODO : implement getting slender curve from section data

    private TypeOfSlenderCurve slenderCurve;
    {
        slenderCurve = TypeOfSlenderCurve.B;
    }

    private Double deltaModulusY;

    //
    private Double bucklingModulusY;

    private Double colComprWithBuckModulusY;

    public void loadSectionData(){
        // TODO: 12.05.2021 replase string with constant or move to config file

        section = input.getSectionType().equals("weldedBeam") ?
                initWeldedBeam() :
                sectionRepository
                .findByStandardAndProfileNumber(input.getSectionStandard(), input.getSectionNumber())
                .get(0);
    }

    // TODO: 12.05.2021 swith to javax.measure (see dependency)
    private Section initWeldedBeam() {
        Double flangeWidth = input.getFlangeWidth();
        Double flangeThickness = input.getFlangeThickness();
        Double webDepth = input.getWebDepth();
        Double webThickness = input.getWebThickness();

        Double area = 2 * flangeWidth * flangeThickness + webDepth * webThickness;
        Double width = flangeWidth;
        Double depth = webDepth + 2 * flangeThickness;


        Section weldedBeam = new WeldedIBeamSection();
        return weldedBeam;
    }

    // TODO: 03.05.2021 implement chosing right thickness
    public void loadSteelData(){
        steel = steelRepository
                .findBySteelName(input.getSteel())
                .get(0);
        // TODO: 04.05.2021 handle null fields in steel table 
        designYieldStrange = steel.getDesignYieldStrangeShape();
    }

    //TODO : maybe calculate fields during initialisation

    // lef(m)=mu*l(m)
    public void calculateEffectiveLengthY() {
        effectiveLengthY = input.getEstimatedLengthFactor() * input.getLength();
    }

    // lambda=lef[m]/i[mm]
    public void calculateSlendernessY() {
        slendernessY = effectiveLengthY / section.getRadiusOfGyrationYAxis() * 1000;
    }

    // overlineLambda=lambda*sqrt(Ry[MPa]/E[MPa])
    public void calculateNonDimSlendernessY() {
        nonDimSlendernessY = slendernessY * sqrt(designYieldStrange / modulusOfElasticity);
    }

    // delta=9.87*(1-alpha+beta * overLambda) + overLambda^2
    public void calculateDeltaModulusY(){

        Table8_1Entity table8_1Entity = AlphaAndBetaCoefficients.get(slenderCurve);
        Double alpha = table8_1Entity.getAlpha();
        Double beta = table8_1Entity.getBeta();

        setDeltaModulusY(9.87 * (1 - alpha + beta * nonDimSlendernessY) + nonDimSlendernessY * nonDimSlendernessY);
    }

    // phi=0.5/overLambda^2*(delta-sqrt(delta^2-39.48*overLambda^2))
    public void calculateBucklingModulusY(){
        if(nonDimSlendernessY < 0.4) {
            bucklingModulusY = 1.0;
        }
        else {
            Double bucklingModulusYFirst;
            bucklingModulusYFirst = 0.5 / (nonDimSlendernessY * nonDimSlendernessY) * (deltaModulusY
                    - sqrt(deltaModulusY * deltaModulusY - 39.48 * nonDimSlendernessY * nonDimSlendernessY));

            Double minNonDimSlendernessY = 0.0;
            switch (slenderCurve){
                case A: minNonDimSlendernessY = 3.8;
                    break;
                case B: minNonDimSlendernessY = 4.4;
                    break;
                case C: minNonDimSlendernessY = 5.8;
            }
            if(nonDimSlendernessY > minNonDimSlendernessY){
                // phi should be less then7.6/overlineLambda^2
                Double checkValue = 7.6 / nonDimSlendernessY * nonDimSlendernessY;
                bucklingModulusY = bucklingModulusYFirst > checkValue ? checkValue : bucklingModulusYFirst;
            }
            else {
                bucklingModulusY = bucklingModulusYFirst;
            }
        }
    }

    // TODO : implement including own weight

    // N[t]*gammaN/(phi*A[cm^2]*Ry[MPa]*yc) <= 1
    // TODO : maybe implement inversion MPa > T/sm^2
    // TODO : implement second axis Z
    public void calculateColComprWithBuckModulusY(){
        colComprWithBuckModulusY = input.getNormalForce() * 9.81 * 10 * input.getReliabilityFactorForResponsibility() /
                (bucklingModulusY * section.getArea() * designYieldStrange *
                input.getWorkingConditionsFactor());
    }

    public ColComprWithBuckDto getInput() {
        return input;
    }

    public Double getEffectiveLengthY() {
        return effectiveLengthY;
    }

    public void setEffectiveLengthY(Double effectiveLengthY) {
        this.effectiveLengthY = effectiveLengthY;
    }

    public Double getSlendernessY() {
        return slendernessY;
    }

    public void setSlendernessY(Double slendernessY) {
        this.slendernessY = slendernessY;
    }

    public Double getDesignYieldStrange() {
        return designYieldStrange;
    }

    public void setDesignYieldStrange(Double designYieldStrange) {
        this.designYieldStrange = designYieldStrange;
    }

    public static Double getModulusOfElasticity() {
        return modulusOfElasticity;
    }

    public static void setModulusOfElasticity(Double modulusOfElasticity) {
        ColComprWithBuckCalcUnit.modulusOfElasticity = modulusOfElasticity;
    }
}
