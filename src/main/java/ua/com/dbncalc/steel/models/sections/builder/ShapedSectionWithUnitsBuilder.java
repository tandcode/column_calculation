package ua.com.dbncalc.steel.models.sections.builder;

import ua.com.dbncalc.steel.models.sections.with_units.ShapedSectionWithUnits;
import ua.com.dbncalc.steel.services.util.units.quantity.SecondMoment;
import ua.com.dbncalc.steel.services.util.units.quantity.WeightPerLength;

import javax.measure.Quantity;
import javax.measure.quantity.Area;
import javax.measure.quantity.Length;
import javax.measure.quantity.Volume;

public final class ShapedSectionWithUnitsBuilder {
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

    private ShapedSectionWithUnitsBuilder() {
    }

    public static ShapedSectionWithUnitsBuilder aShapedSectionWithUnits() {
        return new ShapedSectionWithUnitsBuilder();
    }

    public ShapedSectionWithUnitsBuilder withDepth(Quantity<Length> depth) {
        this.depth = depth;
        return this;
    }

    public ShapedSectionWithUnitsBuilder withWidth(Quantity<Length> width) {
        this.width = width;
        return this;
    }

    public ShapedSectionWithUnitsBuilder withArea(Quantity<Area> area) {
        this.area = area;
        return this;
    }

    public ShapedSectionWithUnitsBuilder withWeightPerLength(Quantity<WeightPerLength> weightPerLength) {
        this.weightPerLength = weightPerLength;
        return this;
    }

    public ShapedSectionWithUnitsBuilder withSecondMomentAboutYAxis(Quantity<SecondMoment> secondMomentAboutYAxis) {
        this.secondMomentAboutYAxis = secondMomentAboutYAxis;
        return this;
    }

    public ShapedSectionWithUnitsBuilder withSecondMomentAboutZAxis(Quantity<SecondMoment> secondMomentAboutZAxis) {
        this.secondMomentAboutZAxis = secondMomentAboutZAxis;
        return this;
    }

    public ShapedSectionWithUnitsBuilder withSectionModulusAboutYAxis(Quantity<Volume> sectionModulusAboutYAxis) {
        this.sectionModulusAboutYAxis = sectionModulusAboutYAxis;
        return this;
    }

    public ShapedSectionWithUnitsBuilder withSectionModulusAboutZAxis(Quantity<Volume> sectionModulusAboutZAxis) {
        this.sectionModulusAboutZAxis = sectionModulusAboutZAxis;
        return this;
    }

    public ShapedSectionWithUnitsBuilder withRadiusOfGyrationYAxis(Quantity<Length> radiusOfGyrationYAxis) {
        this.radiusOfGyrationYAxis = radiusOfGyrationYAxis;
        return this;
    }

    public ShapedSectionWithUnitsBuilder withRadiusOfGyrationZAxis(Quantity<Length> radiusOfGyrationZAxis) {
        this.radiusOfGyrationZAxis = radiusOfGyrationZAxis;
        return this;
    }

    public ShapedSectionWithUnitsBuilder withId(Integer id) {
        this.id = id;
        return this;
    }

    public ShapedSectionWithUnitsBuilder withStandard(String standard) {
        this.standard = standard;
        return this;
    }

    public ShapedSectionWithUnitsBuilder withProfileNumber(String profileNumber) {
        this.profileNumber = profileNumber;
        return this;
    }

    public ShapedSectionWithUnits build() {
        ShapedSectionWithUnits shapedSectionWithUnits = new ShapedSectionWithUnits();
        shapedSectionWithUnits.setDepth(depth);
        shapedSectionWithUnits.setWidth(width);
        shapedSectionWithUnits.setArea(area);
        shapedSectionWithUnits.setWeightPerLength(weightPerLength);
        shapedSectionWithUnits.setSecondMomentAboutYAxis(secondMomentAboutYAxis);
        shapedSectionWithUnits.setSecondMomentAboutZAxis(secondMomentAboutZAxis);
        shapedSectionWithUnits.setSectionModulusAboutYAxis(sectionModulusAboutYAxis);
        shapedSectionWithUnits.setSectionModulusAboutZAxis(sectionModulusAboutZAxis);
        shapedSectionWithUnits.setRadiusOfGyrationYAxis(radiusOfGyrationYAxis);
        shapedSectionWithUnits.setRadiusOfGyrationZAxis(radiusOfGyrationZAxis);
        shapedSectionWithUnits.setId(id);
        shapedSectionWithUnits.setStandard(standard);
        shapedSectionWithUnits.setProfileNumber(profileNumber);
        return shapedSectionWithUnits;
    }
}
