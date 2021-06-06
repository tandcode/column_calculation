package ua.com.dbncalc.steel.models.sections.builder;

import ua.com.dbncalc.steel.models.sections.with_units.HollowSectionWithUnits;
import ua.com.dbncalc.steel.services.util.units.quantity.SecondMoment;
import ua.com.dbncalc.steel.services.util.units.quantity.WeightPerLength;

import javax.measure.Quantity;
import javax.measure.quantity.Area;
import javax.measure.quantity.Length;
import javax.measure.quantity.Volume;

public final class HollowSectionWithUnitsBuilder {
    //web thickness (s) in mm
    private Quantity<Length> webThick;
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

    private HollowSectionWithUnitsBuilder() {
    }

    public static HollowSectionWithUnitsBuilder aHollowSectionWithUnits() {
        return new HollowSectionWithUnitsBuilder();
    }

    public HollowSectionWithUnitsBuilder withWebThick(Quantity<Length> webThick) {
        this.webThick = webThick;
        return this;
    }

    public HollowSectionWithUnitsBuilder withInsideRadius(Quantity<Length> insideRadius) {
        this.insideRadius = insideRadius;
        return this;
    }

    public HollowSectionWithUnitsBuilder withDepth(Quantity<Length> depth) {
        this.depth = depth;
        return this;
    }

    public HollowSectionWithUnitsBuilder withWidth(Quantity<Length> width) {
        this.width = width;
        return this;
    }

    public HollowSectionWithUnitsBuilder withArea(Quantity<Area> area) {
        this.area = area;
        return this;
    }

    public HollowSectionWithUnitsBuilder withWeightPerLength(Quantity<WeightPerLength> weightPerLength) {
        this.weightPerLength = weightPerLength;
        return this;
    }

    public HollowSectionWithUnitsBuilder withSecondMomentAboutYAxis(Quantity<SecondMoment> secondMomentAboutYAxis) {
        this.secondMomentAboutYAxis = secondMomentAboutYAxis;
        return this;
    }

    public HollowSectionWithUnitsBuilder withSecondMomentAboutZAxis(Quantity<SecondMoment> secondMomentAboutZAxis) {
        this.secondMomentAboutZAxis = secondMomentAboutZAxis;
        return this;
    }

    public HollowSectionWithUnitsBuilder withSectionModulusAboutYAxis(Quantity<Volume> sectionModulusAboutYAxis) {
        this.sectionModulusAboutYAxis = sectionModulusAboutYAxis;
        return this;
    }

    public HollowSectionWithUnitsBuilder withSectionModulusAboutZAxis(Quantity<Volume> sectionModulusAboutZAxis) {
        this.sectionModulusAboutZAxis = sectionModulusAboutZAxis;
        return this;
    }

    public HollowSectionWithUnitsBuilder withRadiusOfGyrationYAxis(Quantity<Length> radiusOfGyrationYAxis) {
        this.radiusOfGyrationYAxis = radiusOfGyrationYAxis;
        return this;
    }

    public HollowSectionWithUnitsBuilder withRadiusOfGyrationZAxis(Quantity<Length> radiusOfGyrationZAxis) {
        this.radiusOfGyrationZAxis = radiusOfGyrationZAxis;
        return this;
    }

    public HollowSectionWithUnitsBuilder withId(Integer id) {
        this.id = id;
        return this;
    }

    public HollowSectionWithUnitsBuilder withStandard(String standard) {
        this.standard = standard;
        return this;
    }

    public HollowSectionWithUnitsBuilder withProfileNumber(String profileNumber) {
        this.profileNumber = profileNumber;
        return this;
    }

    public HollowSectionWithUnits build() {
        HollowSectionWithUnits hollowSectionWithUnits = new HollowSectionWithUnits();
        hollowSectionWithUnits.setWebThick(webThick);
        hollowSectionWithUnits.setInsideRadius(insideRadius);
        hollowSectionWithUnits.setDepth(depth);
        hollowSectionWithUnits.setWidth(width);
        hollowSectionWithUnits.setArea(area);
        hollowSectionWithUnits.setWeightPerLength(weightPerLength);
        hollowSectionWithUnits.setSecondMomentAboutYAxis(secondMomentAboutYAxis);
        hollowSectionWithUnits.setSecondMomentAboutZAxis(secondMomentAboutZAxis);
        hollowSectionWithUnits.setSectionModulusAboutYAxis(sectionModulusAboutYAxis);
        hollowSectionWithUnits.setSectionModulusAboutZAxis(sectionModulusAboutZAxis);
        hollowSectionWithUnits.setRadiusOfGyrationYAxis(radiusOfGyrationYAxis);
        hollowSectionWithUnits.setRadiusOfGyrationZAxis(radiusOfGyrationZAxis);
        hollowSectionWithUnits.setId(id);
        hollowSectionWithUnits.setStandard(standard);
        hollowSectionWithUnits.setProfileNumber(profileNumber);
        return hollowSectionWithUnits;
    }
}
