package ua.com.dbncalc.steel.models.sections.builder;

import ua.com.dbncalc.steel.models.sections.with_units.IBeamRoundedFlangeSectionWithUnits;
import ua.com.dbncalc.steel.services.util.units.quantity.SecondMoment;
import ua.com.dbncalc.steel.services.util.units.quantity.WeightPerLength;

import javax.measure.Quantity;
import javax.measure.quantity.Area;
import javax.measure.quantity.Length;
import javax.measure.quantity.Volume;

public final class IBeamRoundedFlangeSectionWithUnitsBuilder {
    //outside radius (r2) in mm
    private Quantity<Length> outsideRadius;
    //web thickness (s) in mm
    private Quantity<Length> webThick;
    //flange thickness (t) in mm
    private Quantity<Length> flangeThick;
    //section first moment about Y axis (Sy) in sm^3
    private Quantity<Volume> firstMomentAboutYAxis;
    //inside radius (r1) in mm
    private Quantity<Length> insideRadius;
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

    private IBeamRoundedFlangeSectionWithUnitsBuilder() {
    }

    public static IBeamRoundedFlangeSectionWithUnitsBuilder anIBeamRoundedFlangeSectionWithUnits() {
        return new IBeamRoundedFlangeSectionWithUnitsBuilder();
    }

    public IBeamRoundedFlangeSectionWithUnitsBuilder withOutsideRadius(Quantity<Length> outsideRadius) {
        this.outsideRadius = outsideRadius;
        return this;
    }

    public IBeamRoundedFlangeSectionWithUnitsBuilder withWebThick(Quantity<Length> webThick) {
        this.webThick = webThick;
        return this;
    }

    public IBeamRoundedFlangeSectionWithUnitsBuilder withFlangeThick(Quantity<Length> flangeThick) {
        this.flangeThick = flangeThick;
        return this;
    }

    public IBeamRoundedFlangeSectionWithUnitsBuilder withFirstMomentAboutYAxis(Quantity<Volume> firstMomentAboutYAxis) {
        this.firstMomentAboutYAxis = firstMomentAboutYAxis;
        return this;
    }

    public IBeamRoundedFlangeSectionWithUnitsBuilder withInsideRadius(Quantity<Length> insideRadius) {
        this.insideRadius = insideRadius;
        return this;
    }

    public IBeamRoundedFlangeSectionWithUnitsBuilder withDepth(Quantity<Length> depth) {
        this.depth = depth;
        return this;
    }

    public IBeamRoundedFlangeSectionWithUnitsBuilder withWidth(Quantity<Length> width) {
        this.width = width;
        return this;
    }

    public IBeamRoundedFlangeSectionWithUnitsBuilder withArea(Quantity<Area> area) {
        this.area = area;
        return this;
    }

    public IBeamRoundedFlangeSectionWithUnitsBuilder withWeightPerLength(Quantity<WeightPerLength> weightPerLength) {
        this.weightPerLength = weightPerLength;
        return this;
    }

    public IBeamRoundedFlangeSectionWithUnitsBuilder withSecondMomentAboutYAxis(Quantity<SecondMoment> secondMomentAboutYAxis) {
        this.secondMomentAboutYAxis = secondMomentAboutYAxis;
        return this;
    }

    public IBeamRoundedFlangeSectionWithUnitsBuilder withSecondMomentAboutZAxis(Quantity<SecondMoment> secondMomentAboutZAxis) {
        this.secondMomentAboutZAxis = secondMomentAboutZAxis;
        return this;
    }

    public IBeamRoundedFlangeSectionWithUnitsBuilder withSectionModulusAboutYAxis(Quantity<Volume> sectionModulusAboutYAxis) {
        this.sectionModulusAboutYAxis = sectionModulusAboutYAxis;
        return this;
    }

    public IBeamRoundedFlangeSectionWithUnitsBuilder withSectionModulusAboutZAxis(Quantity<Volume> sectionModulusAboutZAxis) {
        this.sectionModulusAboutZAxis = sectionModulusAboutZAxis;
        return this;
    }

    public IBeamRoundedFlangeSectionWithUnitsBuilder withRadiusOfGyrationYAxis(Quantity<Length> radiusOfGyrationYAxis) {
        this.radiusOfGyrationYAxis = radiusOfGyrationYAxis;
        return this;
    }

    public IBeamRoundedFlangeSectionWithUnitsBuilder withRadiusOfGyrationZAxis(Quantity<Length> radiusOfGyrationZAxis) {
        this.radiusOfGyrationZAxis = radiusOfGyrationZAxis;
        return this;
    }

    public IBeamRoundedFlangeSectionWithUnitsBuilder withId(Integer id) {
        this.id = id;
        return this;
    }

    public IBeamRoundedFlangeSectionWithUnitsBuilder withStandard(String standard) {
        this.standard = standard;
        return this;
    }

    public IBeamRoundedFlangeSectionWithUnitsBuilder withProfileNumber(String profileNumber) {
        this.profileNumber = profileNumber;
        return this;
    }

    public IBeamRoundedFlangeSectionWithUnits build() {
        IBeamRoundedFlangeSectionWithUnits iBeamRoundedFlangeSectionWithUnits = new IBeamRoundedFlangeSectionWithUnits();
        iBeamRoundedFlangeSectionWithUnits.setOutsideRadius(outsideRadius);
        iBeamRoundedFlangeSectionWithUnits.setWebThick(webThick);
        iBeamRoundedFlangeSectionWithUnits.setFlangeThick(flangeThick);
        iBeamRoundedFlangeSectionWithUnits.setFirstMomentAboutYAxis(firstMomentAboutYAxis);
        iBeamRoundedFlangeSectionWithUnits.setInsideRadius(insideRadius);
        iBeamRoundedFlangeSectionWithUnits.setDepth(depth);
        iBeamRoundedFlangeSectionWithUnits.setWidth(width);
        iBeamRoundedFlangeSectionWithUnits.setArea(area);
        iBeamRoundedFlangeSectionWithUnits.setWeightPerLength(weightPerLength);
        iBeamRoundedFlangeSectionWithUnits.setSecondMomentAboutYAxis(secondMomentAboutYAxis);
        iBeamRoundedFlangeSectionWithUnits.setSecondMomentAboutZAxis(secondMomentAboutZAxis);
        iBeamRoundedFlangeSectionWithUnits.setSectionModulusAboutYAxis(sectionModulusAboutYAxis);
        iBeamRoundedFlangeSectionWithUnits.setSectionModulusAboutZAxis(sectionModulusAboutZAxis);
        iBeamRoundedFlangeSectionWithUnits.setRadiusOfGyrationYAxis(radiusOfGyrationYAxis);
        iBeamRoundedFlangeSectionWithUnits.setRadiusOfGyrationZAxis(radiusOfGyrationZAxis);
        iBeamRoundedFlangeSectionWithUnits.setId(id);
        iBeamRoundedFlangeSectionWithUnits.setStandard(standard);
        iBeamRoundedFlangeSectionWithUnits.setProfileNumber(profileNumber);
        return iBeamRoundedFlangeSectionWithUnits;
    }
}
