package ua.com.dbncalc.steel.models.sections.builder;

import ua.com.dbncalc.steel.models.sections.with_units.WeldedIBeamSectionWithUnits;
import ua.com.dbncalc.steel.services.util.units.quantity.SecondMoment;
import ua.com.dbncalc.steel.services.util.units.quantity.WeightPerLength;

import javax.measure.Quantity;
import javax.measure.quantity.Area;
import javax.measure.quantity.Length;
import javax.measure.quantity.Volume;

public final class WeldedIBeamSectionWithUnitsBuilder {
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
    //leg of the weld between web and flange (k) in mm
    private Quantity<Length> legOfWeld;
    //welded beam sheets in mm
    private Quantity<Length> flangeWidth;
    private Quantity<Length> flangeThickness;
    private Quantity<Length> webDepth;
    private Quantity<Length> webThickness;

    private WeldedIBeamSectionWithUnitsBuilder() {
    }

    public static WeldedIBeamSectionWithUnitsBuilder aWeldedIBeamSectionWithUnits() {
        return new WeldedIBeamSectionWithUnitsBuilder();
    }

    public WeldedIBeamSectionWithUnitsBuilder withDepth(Quantity<Length> depth) {
        this.depth = depth;
        return this;
    }

    public WeldedIBeamSectionWithUnitsBuilder withWidth(Quantity<Length> width) {
        this.width = width;
        return this;
    }

    public WeldedIBeamSectionWithUnitsBuilder withArea(Quantity<Area> area) {
        this.area = area;
        return this;
    }

    public WeldedIBeamSectionWithUnitsBuilder withWeightPerLength(Quantity<WeightPerLength> weightPerLength) {
        this.weightPerLength = weightPerLength;
        return this;
    }

    public WeldedIBeamSectionWithUnitsBuilder withSecondMomentAboutYAxis(Quantity<SecondMoment> secondMomentAboutYAxis) {
        this.secondMomentAboutYAxis = secondMomentAboutYAxis;
        return this;
    }

    public WeldedIBeamSectionWithUnitsBuilder withSecondMomentAboutZAxis(Quantity<SecondMoment> secondMomentAboutZAxis) {
        this.secondMomentAboutZAxis = secondMomentAboutZAxis;
        return this;
    }

    public WeldedIBeamSectionWithUnitsBuilder withSectionModulusAboutYAxis(Quantity<Volume> sectionModulusAboutYAxis) {
        this.sectionModulusAboutYAxis = sectionModulusAboutYAxis;
        return this;
    }

    public WeldedIBeamSectionWithUnitsBuilder withSectionModulusAboutZAxis(Quantity<Volume> sectionModulusAboutZAxis) {
        this.sectionModulusAboutZAxis = sectionModulusAboutZAxis;
        return this;
    }

    public WeldedIBeamSectionWithUnitsBuilder withRadiusOfGyrationYAxis(Quantity<Length> radiusOfGyrationYAxis) {
        this.radiusOfGyrationYAxis = radiusOfGyrationYAxis;
        return this;
    }

    public WeldedIBeamSectionWithUnitsBuilder withRadiusOfGyrationZAxis(Quantity<Length> radiusOfGyrationZAxis) {
        this.radiusOfGyrationZAxis = radiusOfGyrationZAxis;
        return this;
    }

    public WeldedIBeamSectionWithUnitsBuilder withLegOfWeld(Quantity<Length> legOfWeld) {
        this.legOfWeld = legOfWeld;
        return this;
    }

    public WeldedIBeamSectionWithUnitsBuilder withFlangeWidth(Quantity<Length> flangeWidth) {
        this.flangeWidth = flangeWidth;
        return this;
    }

    public WeldedIBeamSectionWithUnitsBuilder withFlangeThickness(Quantity<Length> flangeThickness) {
        this.flangeThickness = flangeThickness;
        return this;
    }

    public WeldedIBeamSectionWithUnitsBuilder withWebDepth(Quantity<Length> webDepth) {
        this.webDepth = webDepth;
        return this;
    }

    public WeldedIBeamSectionWithUnitsBuilder withWebThickness(Quantity<Length> webThickness) {
        this.webThickness = webThickness;
        return this;
    }

    public WeldedIBeamSectionWithUnits build() {
        WeldedIBeamSectionWithUnits weldedIBeamSectionWithUnits = new WeldedIBeamSectionWithUnits();
        weldedIBeamSectionWithUnits.setDepth(depth);
        weldedIBeamSectionWithUnits.setWidth(width);
        weldedIBeamSectionWithUnits.setArea(area);
        weldedIBeamSectionWithUnits.setWeightPerLength(weightPerLength);
        weldedIBeamSectionWithUnits.setSecondMomentAboutYAxis(secondMomentAboutYAxis);
        weldedIBeamSectionWithUnits.setSecondMomentAboutZAxis(secondMomentAboutZAxis);
        weldedIBeamSectionWithUnits.setSectionModulusAboutYAxis(sectionModulusAboutYAxis);
        weldedIBeamSectionWithUnits.setSectionModulusAboutZAxis(sectionModulusAboutZAxis);
        weldedIBeamSectionWithUnits.setRadiusOfGyrationYAxis(radiusOfGyrationYAxis);
        weldedIBeamSectionWithUnits.setRadiusOfGyrationZAxis(radiusOfGyrationZAxis);
        weldedIBeamSectionWithUnits.setLegOfWeld(legOfWeld);
        weldedIBeamSectionWithUnits.setFlangeWidth(flangeWidth);
        weldedIBeamSectionWithUnits.setFlangeThick(flangeThickness);
        weldedIBeamSectionWithUnits.setWebDepth(webDepth);
        weldedIBeamSectionWithUnits.setWebThick(webThickness);
        return weldedIBeamSectionWithUnits;
    }
}
