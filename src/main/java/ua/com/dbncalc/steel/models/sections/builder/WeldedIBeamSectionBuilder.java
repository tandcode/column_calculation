package ua.com.dbncalc.steel.models.sections.builder;

import ua.com.dbncalc.steel.models.sections.WeldedIBeamSection;

public final class WeldedIBeamSectionBuilder {
    //section depth (h) in mm
    private Double depth;
    //section width (b) in mm
    private Double width;
    //section area (A) in sm^2
    private Double area;
    //section weight per length (P) in kg/m
    private Double weightPerLength;
    //section second moment about Y axis (Iy) in sm^4
    private Double secondMomentAboutYAxis;
    //section second moment about Z axis (Iz) in sm^4
    private Double secondMomentAboutZAxis;
    //section modulus about Y axis (Wy) in sm^3
    private Double sectionModulusAboutYAxis;
    //section modulus about Z axis (Wz) in sm^3
    private Double sectionModulusAboutZAxis;
    //section radius of gyration Y axis (iy) in mm
    private Double radiusOfGyrationYAxis;
    //section radius of gyration Z axis (iz) in mm
    private Double radiusOfGyrationZAxis;
    //leg of the weld between web and flange (k) in mm
    private Double legOfWeld;
    //welded beam sheets in mm
    private Double flangeWidth;
    private Double flangeThickness;
    private Double webDepth;
    private Double webThickness;

    private WeldedIBeamSectionBuilder() {
    }

    public static WeldedIBeamSectionBuilder aWeldedIBeamSection() {
        return new WeldedIBeamSectionBuilder();
    }

    public WeldedIBeamSectionBuilder withDepth(Double depth) {
        this.depth = depth;
        return this;
    }

    public WeldedIBeamSectionBuilder withWidth(Double width) {
        this.width = width;
        return this;
    }

    public WeldedIBeamSectionBuilder withArea(Double area) {
        this.area = area;
        return this;
    }

    public WeldedIBeamSectionBuilder withWeightPerLength(Double weightPerLength) {
        this.weightPerLength = weightPerLength;
        return this;
    }

    public WeldedIBeamSectionBuilder withSecondMomentAboutYAxis(Double secondMomentAboutYAxis) {
        this.secondMomentAboutYAxis = secondMomentAboutYAxis;
        return this;
    }

    public WeldedIBeamSectionBuilder withSecondMomentAboutZAxis(Double secondMomentAboutZAxis) {
        this.secondMomentAboutZAxis = secondMomentAboutZAxis;
        return this;
    }

    public WeldedIBeamSectionBuilder withSectionModulusAboutYAxis(Double sectionModulusAboutYAxis) {
        this.sectionModulusAboutYAxis = sectionModulusAboutYAxis;
        return this;
    }

    public WeldedIBeamSectionBuilder withSectionModulusAboutZAxis(Double sectionModulusAboutZAxis) {
        this.sectionModulusAboutZAxis = sectionModulusAboutZAxis;
        return this;
    }

    public WeldedIBeamSectionBuilder withRadiusOfGyrationYAxis(Double radiusOfGyrationYAxis) {
        this.radiusOfGyrationYAxis = radiusOfGyrationYAxis;
        return this;
    }

    public WeldedIBeamSectionBuilder withRadiusOfGyrationZAxis(Double radiusOfGyrationZAxis) {
        this.radiusOfGyrationZAxis = radiusOfGyrationZAxis;
        return this;
    }

    public WeldedIBeamSectionBuilder withLegOfWeld(Double legOfWeld) {
        this.legOfWeld = legOfWeld;
        return this;
    }

    public WeldedIBeamSectionBuilder withFlangeWidth(Double flangeWidth) {
        this.flangeWidth = flangeWidth;
        return this;
    }

    public WeldedIBeamSectionBuilder withFlangeThickness(Double flangeThickness) {
        this.flangeThickness = flangeThickness;
        return this;
    }

    public WeldedIBeamSectionBuilder withWebDepth(Double webDepth) {
        this.webDepth = webDepth;
        return this;
    }

    public WeldedIBeamSectionBuilder withWebThickness(Double webThickness) {
        this.webThickness = webThickness;
        return this;
    }

    public WeldedIBeamSection build() {
        WeldedIBeamSection weldedIBeamSection = new WeldedIBeamSection();
        weldedIBeamSection.setDepth(depth);
        weldedIBeamSection.setWidth(width);
        weldedIBeamSection.setArea(area);
        weldedIBeamSection.setWeightPerLength(weightPerLength);
        weldedIBeamSection.setSecondMomentAboutYAxis(secondMomentAboutYAxis);
        weldedIBeamSection.setSecondMomentAboutZAxis(secondMomentAboutZAxis);
        weldedIBeamSection.setSectionModulusAboutYAxis(sectionModulusAboutYAxis);
        weldedIBeamSection.setSectionModulusAboutZAxis(sectionModulusAboutZAxis);
        weldedIBeamSection.setRadiusOfGyrationYAxis(radiusOfGyrationYAxis);
        weldedIBeamSection.setRadiusOfGyrationZAxis(radiusOfGyrationZAxis);
        weldedIBeamSection.setLegOfWeld(legOfWeld);
        weldedIBeamSection.setFlangeWidth(flangeWidth);
        weldedIBeamSection.setFlangeThickness(flangeThickness);
        weldedIBeamSection.setWebDepth(webDepth);
        weldedIBeamSection.setWebThickness(webThickness);
        return weldedIBeamSection;
    }
}
