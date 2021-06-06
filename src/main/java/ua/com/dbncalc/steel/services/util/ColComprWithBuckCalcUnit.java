package ua.com.dbncalc.steel.services.util;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import tech.units.indriya.ComparableQuantity;
import tech.units.indriya.quantity.Quantities;
import ua.com.dbncalc.steel.dto.ColComprWithBuckDto;
import ua.com.dbncalc.steel.models.sections.Section;
import ua.com.dbncalc.steel.models.sections.builder.SectionWithUnitsBuilder;
import ua.com.dbncalc.steel.models.sections.builder.WeldedIBeamSectionWithUnitsBuilder;
import ua.com.dbncalc.steel.models.sections.with_units.SectionWithUnits;
import ua.com.dbncalc.steel.models.steels.Steel;
import ua.com.dbncalc.steel.repositories.SectionRepository;
import ua.com.dbncalc.steel.repositories.SteelRepository;
import ua.com.dbncalc.steel.services.Table8_1Entity;
import ua.com.dbncalc.steel.services.util.units.quantity.*;

import javax.measure.Quantity;
import javax.measure.quantity.*;
import java.util.Map;

import static tech.units.indriya.AbstractUnit.ONE;
import static tech.units.indriya.unit.Units.METRE;
import static ua.com.dbncalc.steel.services.util.units.StructuralUnits.*;

@NoArgsConstructor
@Getter
@Setter
//@Component
public class ColComprWithBuckCalcUnit {

    public static final ComparableQuantity<Density> steelDensity = Quantities.getQuantity(7850, KILOGRAM_PER_CUBIC_METRE);

    private ColComprWithBuckDto input;
    // TODO: 03.05.2021 change to section
    private SectionWithUnits section;

    private Steel steel;
    // TODO: 04.05.2021 replace the different repositories of sections by one table of sections
    // TODO: 04.05.2021 Implement calculation geom props for welded I-beam
    @Autowired
    private SectionRepository sectionRepository;

    // TODO: realize calculation for Z axis

    @Autowired
    private SteelRepository steelRepository;

    private Section.SectionType sectionType;
    //element length in m
    private ComparableQuantity<Length> length;
    //estimated length factor
    private ComparableQuantity<Dimensionless> estimatedLengthFactor;
    //working conditions factor (gammaC)
    private ComparableQuantity<Dimensionless> workingConditionsFactor;
    //reliability factor for responsibility(gammaN)
    private ComparableQuantity<Dimensionless> reliabilityFactorForResponsibility;
    //calculation moment (M) in t*m
    private ComparableQuantity<Moment> moment;
    //normal force (N)
    private ComparableQuantity<Force> normalForce;
    //normal force (N)
    private ComparableQuantity<Force> normalForceWithOwnWeight;
    //traverse force (Q)
    private ComparableQuantity<Force> traverseForce;

    //effective length Y axis (lefY)
    private ComparableQuantity<Length> effectiveLengthY;

    //slenderness Y axis (lambdaY)
    private ComparableQuantity<Dimensionless> slendernessY;

    //non dimensional slenderness Y axis (overline lambdaY)
    private ComparableQuantity<Dimensionless> nonDimSlendernessY;

    //TODO: implement choosing strange depending on shaped profile or from plates
    //design yield strange (Ry) in MPa
    private ComparableQuantity<Pressure> designYieldStrange;

        // TODO : realize conditional initialization
//    {
//        if (input.getSection() instanceof WeldedIBeamSection)
//                ?
//
//    }

    //steel modulus of elasticity (E)
    private static Quantity<Pressure> modulusOfElasticity = Quantities.getQuantity(2.06e5, MEGAPASCAL);

    public void calculate(ColComprWithBuckDto input) {
        loadInput(input);
        loadSteelData();
        loadSectionData();
        calculateEffectiveLengthY();
        calculateSlendernessY();
        calculateNonDimSlendernessY();
        calculateDeltaModulusY();
        calculateBucklingModulusY();
        calculateColComprWithBuckModulusY();
    }

    // TODO: 29.05.2021 implement chosing unit at front
    private void loadInput(ColComprWithBuckDto input) {
        this.input = input;
        length = Quantities.getQuantity(input.getLength(), METRE);
        estimatedLengthFactor = Quantities.getQuantity(input.getEstimatedLengthFactor(), ONE);
        workingConditionsFactor = Quantities.getQuantity(input.getWorkingConditionsFactor(), ONE);
        reliabilityFactorForResponsibility = Quantities.getQuantity(input.getReliabilityFactorForResponsibility(), ONE);
        moment = Quantities.getQuantity(input.getMoment(), TON_FORCE_METRE);
        normalForce = Quantities.getQuantity(input.getNormalForce(), TON_FORCE);
        traverseForce = Quantities.getQuantity(input.getTraverseForce(), TON_FORCE);
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

    private ComparableQuantity<Dimensionless> deltaModulusY;

    private ComparableQuantity<Dimensionless> bucklingModulusY;

    private ComparableQuantity<Dimensionless> colComprWithBuckModulusY;

    private void loadSectionData(){
        // TODO: 12.05.2021 replace string with constant or move to config file
        sectionType = Section.SectionType.valueOf(input.getSectionType());
        if(sectionType.equals(Section.SectionType.WELDED_I_BEAM)) {
            section = initWeldedBeam();
        }
        else {
            Section sectionFromDB = sectionRepository
                .findByStandardAndProfileNumber(input.getSectionStandard(), input.getSectionNumber())
                .get(0);
            // TODO: 01.06.2021 section that are using in calculation cut the additional info. consider to load full info
            section = SectionWithUnitsBuilder.aSectionWithUnits()
                    .withDepth(Quantities.getQuantity(sectionFromDB.getDepth(), MILLIMETRE))
                    .withWidth(Quantities.getQuantity(sectionFromDB.getWidth(), MILLIMETRE))
                    .withArea(Quantities.getQuantity(sectionFromDB.getArea(), SQUARE_CENTIMETRE))
                    .withWeightPerLength(Quantities.getQuantity(sectionFromDB.getWeightPerLength(), KILOGRAM_PER_METRE))
                    .withSecondMomentAboutYAxis(Quantities.getQuantity(sectionFromDB.getSecondMomentAboutYAxis(), CENTIMETRE_TO_THE_FOURTH))
                    .withSecondMomentAboutZAxis(Quantities.getQuantity(sectionFromDB.getSecondMomentAboutZAxis(), CENTIMETRE_TO_THE_FOURTH))
                    .withSectionModulusAboutYAxis(Quantities.getQuantity(sectionFromDB.getSectionModulusAboutYAxis(), CENTIMETRE_TO_THE_THIRD))
                    .withSectionModulusAboutZAxis(Quantities.getQuantity(sectionFromDB.getSectionModulusAboutZAxis(), CENTIMETRE_TO_THE_THIRD))
                    .withRadiusOfGyrationYAxis(Quantities.getQuantity(sectionFromDB.getRadiusOfGyrationYAxis(), MILLIMETRE))
                    .withRadiusOfGyrationZAxis(Quantities.getQuantity(sectionFromDB.getRadiusOfGyrationZAxis(), MILLIMETRE))
                    .build();
        }
    }

    // TODO: 12.05.2021 swith to javax.measure (see dependency)
    // TODO: 18.05.2021 implement choosing unit from page
    private SectionWithUnits initWeldedBeam() {
        ComparableQuantity<Length> flangeWidth = Quantities.getQuantity(input.getFlangeWidth(), MILLIMETRE);
        ComparableQuantity<Length> flangeThickness = Quantities.getQuantity(input.getFlangeThickness(), MILLIMETRE);
        ComparableQuantity<Length> webDepth = Quantities.getQuantity(input.getWebDepth(), MILLIMETRE);
        ComparableQuantity<Length> webThickness = Quantities.getQuantity(input.getWebThickness(), MILLIMETRE);

        ComparableQuantity<Area> area = flangeWidth.multiply(flangeThickness).multiply(2).asType(Area.class)
                .add(webDepth.multiply(webThickness).asType(Area.class));
        ComparableQuantity<Length> width = flangeWidth;
        ComparableQuantity<Length> depth = webDepth.add(flangeThickness.multiply(2));
        // TODO: 13.05.2021 consider to move constants in separate file
        ComparableQuantity<WeightPerLength> weightPerLength = steelDensity.multiply(area).asType(WeightPerLength.class);

        //section second moment about Y axis (Iy) in sm^4 = 2 * (tf^3*bf/12 + ((hw+tf)/2)^2 * tf*bf) + hw^3*tw/12
        ComparableQuantity<SecondMoment> secondMomentAboutYAxis = (Calc.pow(flangeThickness, 3).multiply(flangeWidth)).divide(12).asType(SecondMoment.class)
                .add(Calc.pow(webDepth.add(flangeThickness).divide(2),2).multiply(flangeThickness).multiply(flangeWidth).asType(SecondMoment.class)).multiply(2)
                .add((Calc.pow(webDepth, 3).multiply(webThickness)).divide(12).asType(SecondMoment.class));

        //section second moment about Z axis (Iz) in sm^4
        ComparableQuantity<SecondMoment> secondMomentAboutZAxis = (Calc.pow(flangeWidth, 3).multiply(flangeThickness)).divide(12).multiply(2).asType(SecondMoment.class)
                .add((Calc.pow(webThickness, 3).multiply(webDepth)).divide(12).asType(SecondMoment.class));

        //section modulus about Y axis (Wy) in sm^3
        ComparableQuantity<Volume> sectionModulusAboutYAxis = secondMomentAboutYAxis.divide(depth.divide(2)).asType(Volume.class);

        //section modulus about Z axis (Wz) in sm^3
        ComparableQuantity<Volume> sectionModulusAboutZAxis = secondMomentAboutZAxis.divide(width.divide(2)).asType(Volume.class);

        //section radius of gyration Y axis (iy) in mm
        ComparableQuantity<Length> radiusOfGyrationYAxis = Calc.sqrt(secondMomentAboutYAxis.divide(area)).asType(Length.class);

        //section radius of gyration Z axis (iz) in mm
        ComparableQuantity<Length> radiusOfGyrationZAxis = Calc.sqrt(secondMomentAboutZAxis.divide(area)).asType(Length.class);

        SectionWithUnits weldedBeam = WeldedIBeamSectionWithUnitsBuilder.aWeldedIBeamSectionWithUnits()
                .withArea(area)
                .withWidth(width)
                .withDepth(depth)
                .withFlangeWidth(flangeWidth)
                .withFlangeThickness(flangeThickness)
                .withWebDepth(webDepth)
                .withWebThickness(webThickness)
                .withWeightPerLength(weightPerLength)
                // TODO: 13.05.2021 remove hardcode
                .withLegOfWeld(Quantities.getQuantity(5, MILLIMETRE))
                .withSecondMomentAboutYAxis(secondMomentAboutYAxis)
                .withSecondMomentAboutZAxis(secondMomentAboutZAxis)
                .withSectionModulusAboutYAxis(sectionModulusAboutYAxis)
                .withSectionModulusAboutZAxis(sectionModulusAboutZAxis)
                .withRadiusOfGyrationYAxis(radiusOfGyrationYAxis)
                .withRadiusOfGyrationZAxis(radiusOfGyrationZAxis)
                .build();
        return weldedBeam;
    }

    // TODO: 03.05.2021 implement chosing right thickness
    private void loadSteelData(){
        steel = steelRepository
                .findBySteelName(input.getSteel())
                .get(0);
        // TODO: 04.05.2021 handle null fields in steel table 
        designYieldStrange = Quantities.getQuantity(steel.getDesignYieldStrangeShape(), MEGAPASCAL);
    }

    //TODO : maybe calculate fields during initialisation

    // lef(m)=mu*l(m)
    private void calculateEffectiveLengthY() {
        effectiveLengthY = estimatedLengthFactor.multiply(length).asType(Length.class);
    }

    // lambda=lef[m]/i[mm]
    private void calculateSlendernessY() {
        slendernessY = (ComparableQuantity<Dimensionless>) effectiveLengthY.divide(section.getRadiusOfGyrationYAxis()).toSystemUnit();
    }

    // overlineLambda=lambda*sqrt(Ry[MPa]/E[MPa])
    private void calculateNonDimSlendernessY() {
        nonDimSlendernessY = slendernessY.multiply(Calc.sqrt(designYieldStrange.divide(modulusOfElasticity))).asType(Dimensionless.class);
    }

    // delta=9.87*(1-alpha+beta * overLambda) + overLambda^2
    private void calculateDeltaModulusY(){
        switch (sectionType) {
            case HOLLOW: slenderCurve = TypeOfSlenderCurve.A;
            break;
            case I_BEAM:
            case WELDED_I_BEAM: slenderCurve = TypeOfSlenderCurve.B;
            break;
            default:slenderCurve = TypeOfSlenderCurve.C;
        }

        Table8_1Entity table8_1Entity = AlphaAndBetaCoefficients.get(slenderCurve);
        ComparableQuantity<Dimensionless> alpha = Quantities.getQuantity(table8_1Entity.getAlpha(), ONE);
        ComparableQuantity<Dimensionless> beta = Quantities.getQuantity(table8_1Entity.getBeta(), ONE);

        setDeltaModulusY(Quantities.getQuantity(9.87, ONE)
                .multiply(Quantities.getQuantity(1, ONE).subtract(alpha).add(beta.multiply(nonDimSlendernessY).asType(Dimensionless.class))).asType(Dimensionless.class)
                .add(Calc.pow(nonDimSlendernessY, 2).asType(Dimensionless.class)));
    }

    // phi=0.5/overLambda^2*(delta-sqrt(delta^2-39.48*overLambda^2))
    private void calculateBucklingModulusY(){
        if(nonDimSlendernessY.isLessThan(Quantities.getQuantity(0.4, ONE))) {
            bucklingModulusY = Quantities.getQuantity(1, ONE);
        }
        else {
            ComparableQuantity<Dimensionless> bucklingModulusYFirst;
            bucklingModulusYFirst = Quantities.getQuantity(0.5, ONE).divide(Calc.pow(nonDimSlendernessY, 2))
                    .multiply(deltaModulusY.subtract(Calc.sqrt(Calc.pow(deltaModulusY, 2).asType(Dimensionless.class)
                            .subtract(Quantities.getQuantity(39.48, ONE).multiply(Calc.pow(nonDimSlendernessY, 2))
                                    .asType(Dimensionless.class))).asType(Dimensionless.class))).asType(Dimensionless.class);

            ComparableQuantity<Dimensionless> minNonDimSlendernessY = Quantities.getQuantity(0, ONE);
            switch (slenderCurve){
                case A: minNonDimSlendernessY = Quantities.getQuantity(3.8, ONE);
                    break;
                case B: minNonDimSlendernessY = Quantities.getQuantity(4.4, ONE);
                    break;
                case C: minNonDimSlendernessY = Quantities.getQuantity(5.8, ONE);
            }
            if(nonDimSlendernessY.isGreaterThan(minNonDimSlendernessY)){
                // phi should be less then7.6/overlineLambda^2
                ComparableQuantity<Dimensionless> checkValue = Quantities.getQuantity(7.6, ONE).divide(Calc.pow(nonDimSlendernessY, 2)).asType(Dimensionless.class);
                bucklingModulusY = bucklingModulusYFirst.isGreaterThan(checkValue) ? checkValue : bucklingModulusYFirst;
            }
            else {
                bucklingModulusY = bucklingModulusYFirst;
            }
        }
    }


    // N*gammaN/(phi*A*Ry*yc) <= 1
    // TODO : maybe implement inversion MPa > T/sm^2
    // TODO : implement second axis Z
    private void calculateColComprWithBuckModulusY(){
        normalForceWithOwnWeight = input.getOwnWeightIncluded()
                ? normalForce.add(section.getWeightPerLength().multiply(length).multiply(STANDARD_GRAVITY).asType(Force.class))
                : normalForce;
        colComprWithBuckModulusY = (ComparableQuantity<Dimensionless>) normalForceWithOwnWeight.multiply(reliabilityFactorForResponsibility)
                .divide(bucklingModulusY.multiply(section.getArea()).multiply(designYieldStrange)
                .multiply(workingConditionsFactor)).toSystemUnit();
    }

}
