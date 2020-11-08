package ua.com.dbncalc.steel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.com.dbncalc.steel.models.ColComprWithBuckInput;
import ua.com.dbncalc.steel.models.sections.Section;
import ua.com.dbncalc.steel.models.sections.WeldedIBeamSection;

import java.util.List;
import java.util.Map;

import static java.lang.Math.sqrt;

public class ColComprWithBuckService {

    private final ColComprWithBuckInput input;

    // TODO: realize calculation for Z axis

    //effective length Y axis (lefY) in m
    private Double effectiveLengthY;

    //slenderness Y axis (lambdaY)
    private Double slendernessY;

    //non dimensional slenderness Y axis (overline lambdaY)
    private Double nonDimSlendernessY;

    //design yield strange (Ry) in N/mm^2
    private Double designYieldStrange;
        // TODO : realize conditional initialization
//    {
//        if (input.getSection() instanceof WeldedIBeamSection)
//                ?
//
//    }

    //steel modulus of elasticity (E) in N/mm^2
    private static Double modulusOfElasticity = 2.06e5;

    public enum TypeOfSlenderCurve{
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


    public Double getNonDimSlendernessY() {
        return nonDimSlendernessY;
    }
    
    public void setNonDimSlendernessY(Double nonDimSlendernessY) {
        this.nonDimSlendernessY = nonDimSlendernessY;
    }


    public ColComprWithBuckService(ColComprWithBuckInput input) {
        this.input = input;
    }

    public void loadSectionData(){

        // TODO : access DB data

        //test data
        input.getSection().setRadiusOfGyrationYAxis(82.8);

    }

    //TODO : maybe calculate fields during initialisation

    // lef=mu*l
    public void calculateEffectiveLengthY() {
        setEffectiveLengthY(input.getEstimatedLengthFactor() * input.getLength());
    }

    // lambda=lef/i
    public void calculateSlendernessY() {
        setEffectiveLengthY(getEffectiveLengthY() / input.getSection().getRadiusOfGyrationYAxis());
    }

    // overline lambda=lambda*sqrt(Ry/E)
    public void calculateNonDimSlendernessY() {
        setNonDimSlendernessY(slendernessY * sqrt(designYieldStrange / modulusOfElasticity));
    }

    public Double getResult(){
        calculateEffectiveLengthY();
        return getEffectiveLengthY();
    }

    public ColComprWithBuckInput getInput() {
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
        ColComprWithBuckService.modulusOfElasticity = modulusOfElasticity;
    }
}
