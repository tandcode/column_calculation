package ua.com.dbncalc.steel.services.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tech.units.indriya.ComparableQuantity;
import tech.units.indriya.quantity.Quantities;
import ua.com.dbncalc.steel.models.CCWBCalculation;
import ua.com.dbncalc.steel.models.CCWBInput;
import ua.com.dbncalc.steel.models.CCWBResult;
import ua.com.dbncalc.steel.models.User;
import ua.com.dbncalc.steel.models.sections.Section;
import ua.com.dbncalc.steel.models.sections.Section.SectionType;
import ua.com.dbncalc.steel.models.sections.builder.WeldedIBeamSectionWithUnitsBuilder;
import ua.com.dbncalc.steel.models.sections.with_units.*;
import ua.com.dbncalc.steel.models.steels.Steel;
import ua.com.dbncalc.steel.repositories.SectionRepository;
import ua.com.dbncalc.steel.repositories.SteelRepository;
import ua.com.dbncalc.steel.services.exceptions.SteelDoesntExistsException;
import ua.com.dbncalc.steel.services.util.units.quantity.*;

import javax.measure.Quantity;
import javax.measure.quantity.*;
import java.util.List;
import java.util.Map;

import static tech.units.indriya.AbstractUnit.ONE;
import static tech.units.indriya.unit.Units.METRE;
import static ua.com.dbncalc.steel.services.util.units.StructuralUnits.*;

@NoArgsConstructor
@Getter
@Setter
public class CCWBCalculationWorker {
    // TODO: 16.08.2021 refactor this worker consider not prototype and so on
    public static final ComparableQuantity<Density> steelDensity = Quantities.getQuantity(7850, KILOGRAM_PER_CUBIC_METRE);

    private CCWBInput input;
    private SectionWithUnits section;
    private Steel steel;

    @Autowired
    private SectionRepository sectionRepository;

    // TODO: realize calculation for Z axis
    @Autowired
    private SteelRepository steelRepository;

    @Autowired
    private ModelMapper modelMapper;

    private Section.SectionType sectionType;
    //element length in m
    private Quantity<Length> length;
    //effective length factor along Y axis
    private Quantity<Dimensionless> effectiveLengthFactorY;
    //effective length factor along Z axis
    private Quantity<Dimensionless> effectiveLengthFactorZ;
    //working conditions factor (gammaC)
    private Quantity<Dimensionless> workingConditionsFactor;
    //reliability factor for responsibility(gammaN)
    private Quantity<Dimensionless> reliabilityFactorForResponsibility;
    //calculation moment (M) in t*m
    private Quantity<Moment> moment;
    //normal force (N)
    private Quantity<Force> normalForce;
    //normal force (N)
    private Quantity<Force> normalForceWithOwnWeight;
    //traverse force (Q)
    private Quantity<Force> traverseForce;

    //effective length Y axis (lefY)
    private Quantity<Length> effectiveLengthY;
    //effective length Z axis (lefZ)
    private Quantity<Length> effectiveLengthZ;

    //slenderness Y axis (lambdaY)
    private Quantity<Dimensionless> slendernessY;
    //slenderness Z axis (lambdaZ)
    private Quantity<Dimensionless> slendernessZ;

    //non dimensional slenderness Y axis (overline lambdaY)
    private Quantity<Dimensionless> nonDimSlendernessY;
    //non dimensional slenderness Z axis (overline lambdaZ)
    private Quantity<Dimensionless> nonDimSlendernessZ;

    //design yield strange (Ry) in MPa
    private Quantity<Pressure> designYieldStrange;

    //steel modulus of elasticity (E)
    private static Quantity<Pressure> modulusOfElasticity = Quantities.getQuantity(2.06e5, MEGAPASCAL);

    private TypeOfSlenderCurve slenderCurve;

    private Quantity<Dimensionless> deltaModulusY;
    private Quantity<Dimensionless> deltaModulusZ;

    private Quantity<Dimensionless> bucklingModulusY;
    private Quantity<Dimensionless> bucklingModulusZ;

    private Quantity<Dimensionless> colComprWithBuckModulusY;
    private Quantity<Dimensionless> colComprWithBuckModulusZ;

    public CCWBCalculation calculate(CCWBInput input, User user) throws SteelDoesntExistsException {
        loadInput(input);
        loadSectionData();
        loadSteelData();
        if(input.getNormalForce() > 0) {
            bucklingModulusY = Quantities.getQuantity(1, ONE);
            bucklingModulusZ = Quantities.getQuantity(1, ONE);
        }
        else {
            effectiveLengthY = calculateEffectiveLength(effectiveLengthFactorY, length);
            effectiveLengthZ = calculateEffectiveLength(effectiveLengthFactorZ, length);

            slendernessY = calculateSlenderness(effectiveLengthY, section.getRadiusOfGyrationYAxis());
            slendernessZ = calculateSlenderness(effectiveLengthZ, section.getRadiusOfGyrationZAxis());

            nonDimSlendernessY = calculateNonDimSlenderness(slendernessY, designYieldStrange);
            nonDimSlendernessZ = calculateNonDimSlenderness(slendernessZ, designYieldStrange);

            slenderCurve = getTypeOfSlenderCurve(sectionType);
            deltaModulusY = calculateDeltaModulus(slenderCurve, nonDimSlendernessY);
            deltaModulusZ = calculateDeltaModulus(slenderCurve, nonDimSlendernessZ);

            bucklingModulusY = calculateBucklingModulus(nonDimSlendernessY, deltaModulusY, slenderCurve);
            bucklingModulusZ = calculateBucklingModulus(nonDimSlendernessZ, deltaModulusZ, slenderCurve);
        }
        colComprWithBuckModulusY = calculateColComprWithBuckModulus(normalForce,
                section,
                length,
                reliabilityFactorForResponsibility,
                workingConditionsFactor,
                bucklingModulusY,
                designYieldStrange,
                input.getOwnWeightIncluded());

        colComprWithBuckModulusZ = calculateColComprWithBuckModulus(normalForce,
                section,
                length,
                reliabilityFactorForResponsibility,
                workingConditionsFactor,
                bucklingModulusZ,
                designYieldStrange,
                input.getOwnWeightIncluded());

        return CCWBCalculation.builder()
                .input(input)
                .result(
                        CCWBResult.builder()
                                .axialComressionYRes(colComprWithBuckModulusY
                                        .getValue().doubleValue())
                                .axialComressionZRes(colComprWithBuckModulusZ
                                        .getValue().doubleValue())

                                .build()
                )
                .user(user)
                .build();
    }

    // TODO: 29.05.2021 implement choosing unit at front
    private void loadInput(CCWBInput input) {
        this.input = input;
        length = Quantities.getQuantity(input.getLength(), METRE);
        effectiveLengthFactorY = Quantities.getQuantity(input.getEffectiveLengthFactorY(), ONE);
        effectiveLengthFactorZ = Quantities.getQuantity(input.getEffectiveLengthFactorZ(), ONE);
        workingConditionsFactor = Quantities.getQuantity(input.getWorkingConditionsFactor(), ONE);
        reliabilityFactorForResponsibility = Quantities.getQuantity(input.getReliabilityFactorForResponsibility(), ONE);
//        moment = Quantities.getQuantity(input.getMoment(), TON_FORCE_METRE);
        normalForce = Quantities.getQuantity(input.getNormalForce(), TON_FORCE);
//        traverseForce = Quantities.getQuantity(input.getTraverseForce(), TON_FORCE);
    }

    private enum TypeOfSlenderCurve{
        A,
        B,
        C
    }

    //table 8.1 of dbn2.6-198:2014
    private static Map<TypeOfSlenderCurve, Table8_1Entity> AlphaAndBetaCoefficients = Map.of(
            TypeOfSlenderCurve.A, new Table8_1Entity(0.03, 0.06),
            TypeOfSlenderCurve.B, new Table8_1Entity(0.04, 0.09),
            TypeOfSlenderCurve.C, new Table8_1Entity(0.04, 0.14)
            );

    private void loadSectionData(){
        sectionType = Section.SectionType.valueOf(input.getSectionType());
        if(sectionType.equals(Section.SectionType.WELDED_I_BEAM)) {
            section = initWeldedBeam();
        }
        else {
            section = mapSectionToSectionWithUnits(sectionRepository
                    .findByStandardAndProfileNumber(input.getSectionStandard(), input.getSectionNumber()).get(),
                    sectionType);
        }
    }

    private SectionWithUnits initWeldedBeam() {
        ComparableQuantity<Length> flangeWidth = Quantities.getQuantity(input.getFlangeWidth(), MILLIMETRE);
        ComparableQuantity<Length> flangeThickness = Quantities.getQuantity(input.getFlangeThickness(), MILLIMETRE);
        ComparableQuantity<Length> webDepth = Quantities.getQuantity(input.getWebDepth(), MILLIMETRE);
        ComparableQuantity<Length> webThickness = Quantities.getQuantity(input.getWebThickness(), MILLIMETRE);
        ComparableQuantity<Length> legOfWeld = Quantities.getQuantity(input.getLegOfWeld(), MILLIMETRE);

        ComparableQuantity<Area> area = flangeWidth.multiply(flangeThickness).multiply(2).asType(Area.class)
                .add(webDepth.multiply(webThickness).asType(Area.class));
        ComparableQuantity<Length> width = flangeWidth;
        ComparableQuantity<Length> depth = webDepth.add(flangeThickness.multiply(2));
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
                .withLegOfWeld(legOfWeld)
                .withSecondMomentAboutYAxis(secondMomentAboutYAxis)
                .withSecondMomentAboutZAxis(secondMomentAboutZAxis)
                .withSectionModulusAboutYAxis(sectionModulusAboutYAxis)
                .withSectionModulusAboutZAxis(sectionModulusAboutZAxis)
                .withRadiusOfGyrationYAxis(radiusOfGyrationYAxis)
                .withRadiusOfGyrationZAxis(radiusOfGyrationZAxis)
                .build();
        return weldedBeam;
    }

    private void loadSteelData() throws SteelDoesntExistsException {
        List<Steel> steelsOfGrade = steelRepository
                .findBySteelName(input.getSteel());
        Double steelThickness = getThicknessSteelPartOfSection().to(MILLIMETRE).getValue().doubleValue();
        Steel steel = steelsOfGrade.stream()
                        .filter(st -> steelThickness >= st.getSteelThickLowLim() &&
                        steelThickness <= st.getSteelThickUppLim())
                        .findFirst()
                        .orElseThrow(SteelDoesntExistsException::new);

        designYieldStrange = Quantities.getQuantity(
                sectionType.equals(Section.SectionType.WELDED_I_BEAM) ?
                        steel.getDesignYieldStrangeSheet() :
                        steel.getDesignYieldStrangeShape()
                , MEGAPASCAL);
    }

    private Quantity<Length> getThicknessSteelPartOfSection() throws SteelDoesntExistsException {
        Quantity<Length> thickness;
        switch (sectionType) {
            case I_BEAM: thickness = ((IBeamSectionWithUnits)section).getFlangeThick();
            break;
            case U_PROFILE: thickness = ((UProfileSectionWithUnits)section).getFlangeThick();
            break;
            case HOLLOW: thickness = ((HollowSectionWithUnits)section).getWebThick();
            break;
            case WELDED_I_BEAM: thickness = ((WeldedIBeamSectionWithUnits)section).getFlangeThick();
            break;
            default: throw new SteelDoesntExistsException();
        }
        return thickness;
    }

    // lef(m)=mu*l(m)
    private Quantity<Length> calculateEffectiveLength(Quantity<Dimensionless> effectiveLengthFactor,
                                                      Quantity<Length> length) {
        return effectiveLengthFactor.multiply(length).asType(Length.class);
    }

    // lambda=lef[m]/i[mm]
    private Quantity<Dimensionless> calculateSlenderness(Quantity<Length> effectiveLength,
                                      Quantity<Length> radiusOfGyration) {
        return (ComparableQuantity<Dimensionless>) effectiveLength.divide(radiusOfGyration).toSystemUnit();
    }

    // overlineLambda=lambda*sqrt(Ry[MPa]/E[MPa])
    private Quantity<Dimensionless> calculateNonDimSlenderness(Quantity<Dimensionless> slenderness,
                                                               Quantity<Pressure> designYieldStrange) {
        return slenderness.multiply(Calc.sqrt(designYieldStrange.divide(modulusOfElasticity))).asType(Dimensionless.class);
    }

    private TypeOfSlenderCurve getTypeOfSlenderCurve(SectionType sectionType) {
        TypeOfSlenderCurve slenderCurve;
        switch (sectionType) {
            case HOLLOW: slenderCurve = TypeOfSlenderCurve.A;
                break;
            case I_BEAM:
            case WELDED_I_BEAM: slenderCurve = TypeOfSlenderCurve.B;
                break;
            default:slenderCurve = TypeOfSlenderCurve.C;
        }
        return slenderCurve;
    }

    // delta=9.87*(1-alpha+beta * overLambda) + overLambda^2
    private Quantity<Dimensionless> calculateDeltaModulus(TypeOfSlenderCurve slenderCurve,
                                                                    Quantity<Dimensionless> nonDimSlenderness){

        Table8_1Entity table8_1Entity = AlphaAndBetaCoefficients.get(slenderCurve);
        ComparableQuantity<Dimensionless> alpha = Quantities.getQuantity(table8_1Entity.getAlpha(), ONE);
        ComparableQuantity<Dimensionless> beta = Quantities.getQuantity(table8_1Entity.getBeta(), ONE);

        return Quantities.getQuantity(9.87, ONE)
                .multiply(Quantities.getQuantity(1, ONE).subtract(alpha).add(beta.multiply(nonDimSlenderness).asType(Dimensionless.class))).asType(Dimensionless.class)
                .add(Calc.pow(nonDimSlenderness, 2).asType(Dimensionless.class));
    }

    // phi=0.5/overLambda^2*(delta-sqrt(delta^2-39.48*overLambda^2))
    private Quantity<Dimensionless> calculateBucklingModulus(Quantity<Dimensionless> nonDimSlenderness,
                                                                       Quantity<Dimensionless> deltaModulus,
                                                                       TypeOfSlenderCurve slenderCurve){
        if(((ComparableQuantity<Dimensionless>)nonDimSlenderness).isLessThan(Quantities.getQuantity(0.4, ONE))) {
            return Quantities.getQuantity(1, ONE);
        }
        else {
            ComparableQuantity<Dimensionless> bucklingModulusFirst;
            bucklingModulusFirst = Quantities.getQuantity(0.5, ONE).divide(Calc.pow(nonDimSlenderness, 2))
                    .multiply(deltaModulus.subtract(Calc.sqrt(Calc.pow(deltaModulus, 2).asType(Dimensionless.class)
                            .subtract(Quantities.getQuantity(39.48, ONE).multiply(Calc.pow(nonDimSlenderness, 2))
                                    .asType(Dimensionless.class))).asType(Dimensionless.class))).asType(Dimensionless.class);

            Quantity<Dimensionless> minNonDimSlenderness;
            switch (slenderCurve){
                case A: minNonDimSlenderness = Quantities.getQuantity(3.8, ONE);
                    break;
                case B: minNonDimSlenderness = Quantities.getQuantity(4.4, ONE);
                    break;
                default: minNonDimSlenderness = Quantities.getQuantity(5.8, ONE);
            }
            if(((ComparableQuantity<Dimensionless>)nonDimSlenderness).isGreaterThan(minNonDimSlenderness)){
                // phi should be less then7.6/overlineLambda^2
                Quantity<Dimensionless> checkValue = Quantities.getQuantity(7.6, ONE).divide(Calc.pow(nonDimSlendernessY, 2)).asType(Dimensionless.class);
                return bucklingModulusFirst.isGreaterThan(checkValue) ? checkValue : bucklingModulusFirst;
            }
            else {
                return bucklingModulusFirst;
            }
        }
    }


    // N*gammaN/(phi*A*Ry*yc) <= 1
    private Quantity<Dimensionless> calculateColComprWithBuckModulus(Quantity<Force> normalForce,
                                                                     SectionWithUnits section,
                                                                     Quantity<Length> length,
                                                                     Quantity<Dimensionless> reliabilityFactorForResponsibility,
                                                                     Quantity<Dimensionless> workingConditionsFactor,
                                                                     Quantity<Dimensionless> bucklingModulus,
                                                                     Quantity<Pressure> designYieldStrange,
                                                                     boolean isOwnWeightIncluded){
        normalForceWithOwnWeight = isOwnWeightIncluded
                ? Calc.abs(normalForce).add(section.getWeightPerLength().multiply(length).multiply(STANDARD_GRAVITY).asType(Force.class))
                : Calc.abs(normalForce);
        return (ComparableQuantity<Dimensionless>) Calc.round(normalForceWithOwnWeight.multiply(reliabilityFactorForResponsibility)
                .divide(bucklingModulus.multiply(section.getArea()).multiply(designYieldStrange)
                        .multiply(workingConditionsFactor)).toSystemUnit(), 3);
    }

    public SectionWithUnits mapSectionToSectionWithUnits(Section section, SectionType sectionType){
        SectionWithUnits sectionWithUnits;

        switch (sectionType) {
            // TODO: 15.08.2021 handle mapping to ibeam rounded flange
            case I_BEAM: sectionWithUnits = modelMapper.map(section, IBeamSectionWithUnits.class);
                break;
            case U_PROFILE: sectionWithUnits = modelMapper.map(section, UProfileSectionWithUnits.class);
                break;
            case HOLLOW: sectionWithUnits = modelMapper.map(section, HollowSectionWithUnits.class);
                break;
            default: throw new IllegalArgumentException("Such section cant be mapped");
        }
        return sectionWithUnits;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Table8_1Entity {
        private Double alpha;
        private Double beta;
    }
}
