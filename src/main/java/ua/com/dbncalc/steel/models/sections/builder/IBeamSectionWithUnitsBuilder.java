package ua.com.dbncalc.steel.models.sections.builder;

import ua.com.dbncalc.steel.models.sections.with_units.IBeamSectionWithUnits;
import ua.com.dbncalc.steel.services.util.units.quantity.SecondMoment;
import ua.com.dbncalc.steel.services.util.units.quantity.WeightPerLength;

import javax.measure.Quantity;
import javax.measure.quantity.Area;
import javax.measure.quantity.Length;
import javax.measure.quantity.Volume;

public final class IBeamSectionWithUnitsBuilder {
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

    private IBeamSectionWithUnitsBuilder() {
    }

    public static IBeamSectionWithUnitsBuilder anIBeamSectionWithUnits() {
        return new IBeamSectionWithUnitsBuilder();
    }

    public IBeamSectionWithUnitsBuilder withWebThick(Quantity<Length> webThick) {
        this.webThick = webThick;
        return this;
    }

    public IBeamSectionWithUnitsBuilder withFlangeThick(Quantity<Length> flangeThick) {
        this.flangeThick = flangeThick;
        return this;
    }

    public IBeamSectionWithUnitsBuilder withFirstMomentAboutYAxis(Quantity<Volume> firstMomentAboutYAxis) {
        this.firstMomentAboutYAxis = firstMomentAboutYAxis;
        return this;
    }

    public IBeamSectionWithUnitsBuilder withInsideRadius(Quantity<Length> insideRadius) {
        this.insideRadius = insideRadius;
        return this;
    }

    public IBeamSectionWithUnitsBuilder withDepth(Quantity<Length> depth) {
        this.depth = depth;
        return this;
    }

    public IBeamSectionWithUnitsBuilder withWidth(Quantity<Length> width) {
        this.width = width;
        return this;
    }

    public IBeamSectionWithUnitsBuilder withArea(Quantity<Area> area) {
        this.area = area;
        return this;
    }

    public IBeamSectionWithUnitsBuilder withWeightPerLength(Quantity<WeightPerLength> weightPerLength) {
        this.weightPerLength = weightPerLength;
        return this;
    }

    public IBeamSectionWithUnitsBuilder withSecondMomentAboutYAxis(Quantity<SecondMoment> secondMomentAboutYAxis) {
        this.secondMomentAboutYAxis = secondMomentAboutYAxis;
        return this;
    }

    public IBeamSectionWithUnitsBuilder withSecondMomentAboutZAxis(Quantity<SecondMoment> secondMomentAboutZAxis) {
        this.secondMomentAboutZAxis = secondMomentAboutZAxis;
        return this;
    }

    public IBeamSectionWithUnitsBuilder withSectionModulusAboutYAxis(Quantity<Volume> sectionModulusAboutYAxis) {
        this.sectionModulusAboutYAxis = sectionModulusAboutYAxis;
        return this;
    }

    public IBeamSectionWithUnitsBuilder withSectionModulusAboutZAxis(Quantity<Volume> sectionModulusAboutZAxis) {
        this.sectionModulusAboutZAxis = sectionModulusAboutZAxis;
        return this;
    }

    public IBeamSectionWithUnitsBuilder withRadiusOfGyrationYAxis(Quantity<Length> radiusOfGyrationYAxis) {
        this.radiusOfGyrationYAxis = radiusOfGyrationYAxis;
        return this;
    }

    public IBeamSectionWithUnitsBuilder withRadiusOfGyrationZAxis(Quantity<Length> radiusOfGyrationZAxis) {
        this.radiusOfGyrationZAxis = radiusOfGyrationZAxis;
        return this;
    }

    public IBeamSectionWithUnitsBuilder withId(Integer id) {
        this.id = id;
        return this;
    }

    public IBeamSectionWithUnitsBuilder withStandard(String standard) {
        this.standard = standard;
        return this;
    }

    public IBeamSectionWithUnitsBuilder withProfileNumber(String profileNumber) {
        this.profileNumber = profileNumber;
        return this;
    }

    public IBeamSectionWithUnits build() {
        IBeamSectionWithUnits iBeamSectionWithUnits = new IBeamSectionWithUnits();
        iBeamSectionWithUnits.setWebThick(webThick);
        iBeamSectionWithUnits.setFlangeThick(flangeThick);
        iBeamSectionWithUnits.setFirstMomentAboutYAxis(firstMomentAboutYAxis);
        iBeamSectionWithUnits.setInsideRadius(insideRadius);
        iBeamSectionWithUnits.setDepth(depth);
        iBeamSectionWithUnits.setWidth(width);
        iBeamSectionWithUnits.setArea(area);
        iBeamSectionWithUnits.setWeightPerLength(weightPerLength);
        iBeamSectionWithUnits.setSecondMomentAboutYAxis(secondMomentAboutYAxis);
        iBeamSectionWithUnits.setSecondMomentAboutZAxis(secondMomentAboutZAxis);
        iBeamSectionWithUnits.setSectionModulusAboutYAxis(sectionModulusAboutYAxis);
        iBeamSectionWithUnits.setSectionModulusAboutZAxis(sectionModulusAboutZAxis);
        iBeamSectionWithUnits.setRadiusOfGyrationYAxis(radiusOfGyrationYAxis);
        iBeamSectionWithUnits.setRadiusOfGyrationZAxis(radiusOfGyrationZAxis);
        iBeamSectionWithUnits.setId(id);
        iBeamSectionWithUnits.setStandard(standard);
        iBeamSectionWithUnits.setProfileNumber(profileNumber);
        return iBeamSectionWithUnits;
    }
}
