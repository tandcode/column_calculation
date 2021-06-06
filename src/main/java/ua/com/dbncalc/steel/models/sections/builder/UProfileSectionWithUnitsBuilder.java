package ua.com.dbncalc.steel.models.sections.builder;

import ua.com.dbncalc.steel.models.sections.with_units.UProfileSectionWithUnits;
import ua.com.dbncalc.steel.services.util.units.quantity.SecondMoment;
import ua.com.dbncalc.steel.services.util.units.quantity.WeightPerLength;

import javax.measure.Quantity;
import javax.measure.quantity.Area;
import javax.measure.quantity.Length;
import javax.measure.quantity.Volume;

public final class UProfileSectionWithUnitsBuilder {
    //section depth (h) in mm
    private Quantity<Length> depth;
    //section width (b) in mm
    private Quantity<Length> width;
    //section area (A) in sm^2
    private Quantity<Area> area;
    //section weight per length (P) in kg/m
    private Quantity<WeightPerLength> weightPerLength;
    //section second moment about Y axis (Iy) in sm^4
    private Quantity<SecondMoment> secondMomentAboutYAxis;
    //section second moment about Z axis (Iz) in sm^4
    private Quantity<SecondMoment> secondMomentAboutZAxis;
    //section modulus about Y axis (Wy) in sm^3
    private Quantity<Volume> sectionModulusAboutYAxis;
    //section modulus about Z axis (Wz) in sm^3
    private Quantity<Volume> sectionModulusAboutZAxis;
    //section radius of gyration Y axis (iy) in mm
    private Quantity<Length> radiusOfGyrationYAxis;
    //section radius of gyration Z axis (iz) in mm
    private Quantity<Length> radiusOfGyrationZAxis;
    private Integer id;
    private String standard;
    //profile number(identifier)
    private String profileNumber;
    //web thickness (s) in mm
    private Quantity<Length> webThick;
    //flange thickness (t) in mm
    private Quantity<Length> flangeThick;
    //inside radius (r1) in mm
    private Quantity<Length> insideRadius;
    //outside radius (r2) in mm
    private Quantity<Length> outsideRadius;
    //section first moment about Y axis (Sy) in sm^3
    private Quantity<Volume> firstMomentAboutYAxis;
    //section length to center of the weight (y0) in mm
    private Quantity<Length> centerOfTheWeight;

    private UProfileSectionWithUnitsBuilder() {
    }

    public static UProfileSectionWithUnitsBuilder anUProfileSectionWithUnits() {
        return new UProfileSectionWithUnitsBuilder();
    }

    public UProfileSectionWithUnitsBuilder withDepth(Quantity<Length> depth) {
        this.depth = depth;
        return this;
    }

    public UProfileSectionWithUnitsBuilder withWidth(Quantity<Length> width) {
        this.width = width;
        return this;
    }

    public UProfileSectionWithUnitsBuilder withArea(Quantity<Area> area) {
        this.area = area;
        return this;
    }

    public UProfileSectionWithUnitsBuilder withWeightPerLength(Quantity<WeightPerLength> weightPerLength) {
        this.weightPerLength = weightPerLength;
        return this;
    }

    public UProfileSectionWithUnitsBuilder withSecondMomentAboutYAxis(Quantity<SecondMoment> secondMomentAboutYAxis) {
        this.secondMomentAboutYAxis = secondMomentAboutYAxis;
        return this;
    }

    public UProfileSectionWithUnitsBuilder withSecondMomentAboutZAxis(Quantity<SecondMoment> secondMomentAboutZAxis) {
        this.secondMomentAboutZAxis = secondMomentAboutZAxis;
        return this;
    }

    public UProfileSectionWithUnitsBuilder withSectionModulusAboutYAxis(Quantity<Volume> sectionModulusAboutYAxis) {
        this.sectionModulusAboutYAxis = sectionModulusAboutYAxis;
        return this;
    }

    public UProfileSectionWithUnitsBuilder withSectionModulusAboutZAxis(Quantity<Volume> sectionModulusAboutZAxis) {
        this.sectionModulusAboutZAxis = sectionModulusAboutZAxis;
        return this;
    }

    public UProfileSectionWithUnitsBuilder withRadiusOfGyrationYAxis(Quantity<Length> radiusOfGyrationYAxis) {
        this.radiusOfGyrationYAxis = radiusOfGyrationYAxis;
        return this;
    }

    public UProfileSectionWithUnitsBuilder withRadiusOfGyrationZAxis(Quantity<Length> radiusOfGyrationZAxis) {
        this.radiusOfGyrationZAxis = radiusOfGyrationZAxis;
        return this;
    }

    public UProfileSectionWithUnitsBuilder withId(Integer id) {
        this.id = id;
        return this;
    }

    public UProfileSectionWithUnitsBuilder withStandard(String standard) {
        this.standard = standard;
        return this;
    }

    public UProfileSectionWithUnitsBuilder withProfileNumber(String profileNumber) {
        this.profileNumber = profileNumber;
        return this;
    }

    public UProfileSectionWithUnitsBuilder withWebThick(Quantity<Length> webThick) {
        this.webThick = webThick;
        return this;
    }

    public UProfileSectionWithUnitsBuilder withFlangeThick(Quantity<Length> flangeThick) {
        this.flangeThick = flangeThick;
        return this;
    }

    public UProfileSectionWithUnitsBuilder withInsideRadius(Quantity<Length> insideRadius) {
        this.insideRadius = insideRadius;
        return this;
    }

    public UProfileSectionWithUnitsBuilder withOutsideRadius(Quantity<Length> outsideRadius) {
        this.outsideRadius = outsideRadius;
        return this;
    }

    public UProfileSectionWithUnitsBuilder withFirstMomentAboutYAxis(Quantity<Volume> firstMomentAboutYAxis) {
        this.firstMomentAboutYAxis = firstMomentAboutYAxis;
        return this;
    }

    public UProfileSectionWithUnitsBuilder withCenterOfTheWeight(Quantity<Length> centerOfTheWeight) {
        this.centerOfTheWeight = centerOfTheWeight;
        return this;
    }

    public UProfileSectionWithUnits build() {
        UProfileSectionWithUnits uProfileSectionWithUnits = new UProfileSectionWithUnits();
        uProfileSectionWithUnits.setDepth(depth);
        uProfileSectionWithUnits.setWidth(width);
        uProfileSectionWithUnits.setArea(area);
        uProfileSectionWithUnits.setWeightPerLength(weightPerLength);
        uProfileSectionWithUnits.setSecondMomentAboutYAxis(secondMomentAboutYAxis);
        uProfileSectionWithUnits.setSecondMomentAboutZAxis(secondMomentAboutZAxis);
        uProfileSectionWithUnits.setSectionModulusAboutYAxis(sectionModulusAboutYAxis);
        uProfileSectionWithUnits.setSectionModulusAboutZAxis(sectionModulusAboutZAxis);
        uProfileSectionWithUnits.setRadiusOfGyrationYAxis(radiusOfGyrationYAxis);
        uProfileSectionWithUnits.setRadiusOfGyrationZAxis(radiusOfGyrationZAxis);
        uProfileSectionWithUnits.setId(id);
        uProfileSectionWithUnits.setStandard(standard);
        uProfileSectionWithUnits.setProfileNumber(profileNumber);
        uProfileSectionWithUnits.setWebThick(webThick);
        uProfileSectionWithUnits.setFlangeThick(flangeThick);
        uProfileSectionWithUnits.setInsideRadius(insideRadius);
        uProfileSectionWithUnits.setOutsideRadius(outsideRadius);
        uProfileSectionWithUnits.setFirstMomentAboutYAxis(firstMomentAboutYAxis);
        uProfileSectionWithUnits.setCenterOfTheWeight(centerOfTheWeight);
        return uProfileSectionWithUnits;
    }
}
