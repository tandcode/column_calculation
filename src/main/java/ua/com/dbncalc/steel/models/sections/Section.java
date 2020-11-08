package ua.com.dbncalc.steel.models.sections;

public abstract class Section {

    //profile standard e.g. gost 8239-89
    private String standard;

    //profile number(identifier)
    private String number;

    //section height (h) in mm
    private Double height;

    //section breadth (b) in mm
    private Double breadth;

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

    public Section() {
    }

    public Section(String standard, String number, Double area) {
        this.standard = standard;
        this.number = number;
        this.area = area;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getBreadth() {
        return breadth;
    }

    public void setBreadth(Double breadth) {
        this.breadth = breadth;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getWeightPerLength() {
        return weightPerLength;
    }

    public void setWeightPerLength(Double weightPerLength) {
        this.weightPerLength = weightPerLength;
    }

    public Double getSecondMomentAboutYAxis() {
        return secondMomentAboutYAxis;
    }

    public void setSecondMomentAboutYAxis(Double secondMomentAboutYAxis) {
        this.secondMomentAboutYAxis = secondMomentAboutYAxis;
    }

    public Double getSecondMomentAboutZAxis() {
        return secondMomentAboutZAxis;
    }

    public void setSecondMomentAboutZAxis(Double secondMomentAboutZAxis) {
        this.secondMomentAboutZAxis = secondMomentAboutZAxis;
    }

    public Double getSectionModulusAboutYAxis() {
        return sectionModulusAboutYAxis;
    }

    public void setSectionModulusAboutYAxis(Double sectionModulusAboutYAxis) {
        this.sectionModulusAboutYAxis = sectionModulusAboutYAxis;
    }

    public Double getSectionModulusAboutZAxis() {
        return sectionModulusAboutZAxis;
    }

    public void setSectionModulusAboutZAxis(Double sectionModulusAboutZAxis) {
        this.sectionModulusAboutZAxis = sectionModulusAboutZAxis;
    }

    public Double getRadiusOfGyrationYAxis() {
        return radiusOfGyrationYAxis;
    }

    public void setRadiusOfGyrationYAxis(Double radiusOfGyrationYAxis) {
        this.radiusOfGyrationYAxis = radiusOfGyrationYAxis;
    }

    public Double getRadiusOfGyrationZAxis() {
        return radiusOfGyrationZAxis;
    }

    public void setRadiusOfGyrationZAxis(Double radiusOfGyrationZAxis) {
        this.radiusOfGyrationZAxis = radiusOfGyrationZAxis;
    }
}
