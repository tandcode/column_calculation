package ua.com.dbncalc.steel.models.sections.builder;

import ua.com.dbncalc.steel.models.sections.with_units.SectionWithUnits;
import ua.com.dbncalc.steel.services.util.units.quantity.SecondMoment;
import ua.com.dbncalc.steel.services.util.units.quantity.WeightPerLength;

import javax.measure.Quantity;
import javax.measure.quantity.Area;
import javax.measure.quantity.Length;
import javax.measure.quantity.Volume;

public final class SectionWithUnitsBuilder {
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

    private SectionWithUnitsBuilder() {
    }

    public static SectionWithUnitsBuilder aSectionWithUnits() {
        return new SectionWithUnitsBuilder();
    }

    public SectionWithUnitsBuilder withDepth(Quantity<Length> depth) {
        this.depth = depth;
        return this;
    }

    public SectionWithUnitsBuilder withWidth(Quantity<Length> width) {
        this.width = width;
        return this;
    }

    public SectionWithUnitsBuilder withArea(Quantity<Area> area) {
        this.area = area;
        return this;
    }

    public SectionWithUnitsBuilder withWeightPerLength(Quantity<WeightPerLength> weightPerLength) {
        this.weightPerLength = weightPerLength;
        return this;
    }

    public SectionWithUnitsBuilder withSecondMomentAboutYAxis(Quantity<SecondMoment> secondMomentAboutYAxis) {
        this.secondMomentAboutYAxis = secondMomentAboutYAxis;
        return this;
    }

    public SectionWithUnitsBuilder withSecondMomentAboutZAxis(Quantity<SecondMoment> secondMomentAboutZAxis) {
        this.secondMomentAboutZAxis = secondMomentAboutZAxis;
        return this;
    }

    public SectionWithUnitsBuilder withSectionModulusAboutYAxis(Quantity<Volume> sectionModulusAboutYAxis) {
        this.sectionModulusAboutYAxis = sectionModulusAboutYAxis;
        return this;
    }

    public SectionWithUnitsBuilder withSectionModulusAboutZAxis(Quantity<Volume> sectionModulusAboutZAxis) {
        this.sectionModulusAboutZAxis = sectionModulusAboutZAxis;
        return this;
    }

    public SectionWithUnitsBuilder withRadiusOfGyrationYAxis(Quantity<Length> radiusOfGyrationYAxis) {
        this.radiusOfGyrationYAxis = radiusOfGyrationYAxis;
        return this;
    }

    public SectionWithUnitsBuilder withRadiusOfGyrationZAxis(Quantity<Length> radiusOfGyrationZAxis) {
        this.radiusOfGyrationZAxis = radiusOfGyrationZAxis;
        return this;
    }

    public SectionWithUnits build() {
        SectionWithUnits sectionWithUnits = new SectionWithUnits();
        sectionWithUnits.setDepth(depth);
        sectionWithUnits.setWidth(width);
        sectionWithUnits.setArea(area);
        sectionWithUnits.setWeightPerLength(weightPerLength);
        sectionWithUnits.setSecondMomentAboutYAxis(secondMomentAboutYAxis);
        sectionWithUnits.setSecondMomentAboutZAxis(secondMomentAboutZAxis);
        sectionWithUnits.setSectionModulusAboutYAxis(sectionModulusAboutYAxis);
        sectionWithUnits.setSectionModulusAboutZAxis(sectionModulusAboutZAxis);
        sectionWithUnits.setRadiusOfGyrationYAxis(radiusOfGyrationYAxis);
        sectionWithUnits.setRadiusOfGyrationZAxis(radiusOfGyrationZAxis);
        return sectionWithUnits;
    }
}
