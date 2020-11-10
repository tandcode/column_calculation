package ua.com.dbncalc.steel.models.sections;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class I_ProfileGost8239_89{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

//    //profile standard e.g. gost 8239-89
//    private String standard;

    //profile number(identifier)
    private String profileNumber;

    //section height (h) in mm
    private Double height;

    //section breadth (b) in mm
    private Double breadth;

    //section area (A) in cm^2
    private Double area;

    //section weight per length (P) in kg/m
    private Double weightPerLength;

    //section second moment about Y axis (Iy) in cm^4
    private Double secondMomentAboutYAxis;

    //section second moment about Z axis (Iz) in cm^4
    private Double secondMomentAboutZAxis;

    //section modulus about Y axis (Wy) in cm^3
    private Double sectionModulusAboutYAxis;

    //section modulus about Z axis (Wz) in cm^3
    private Double sectionModulusAboutZAxis;

    //section radius of gyration Y axis (iy) in mm
    private Double radiusOfGyrationYAxis;

    //section radius of gyration Z axis (iz) in mm
    private Double radiusOfGyrationZAxis;
    //web thickness (s) in mm
    private Double webThick;

    //flange thickness (t) in mm
    private Double flangeThick;

    //section first moment about Y axis (Sy) in sm^3
    private Double firstMomentAboutYAxis;

    //inside radius (r1) in mm
    private Double insideRadius;

    //outside radius (r2) in mm
    private Double outsideRadius;

    public I_ProfileGost8239_89() {
    }

    public I_ProfileGost8239_89(String profileNumber, Double area) {
        this.profileNumber = profileNumber;
        this.area = area;
    }

    public Double getInsideRadius() {
        return insideRadius;
    }

    public void setInsideRadius(Double insideRadius) {
        this.insideRadius = insideRadius;
    }

    public Double getOutsideRadius() {
        return outsideRadius;
    }

    public void setOutsideRadius(Double outsideRadius) {
        this.outsideRadius = outsideRadius;
    }

    public Double getWebThick() {
        return webThick;
    }

    public void setWebThick(Double webThick) {
        this.webThick = webThick;
    }

    public Double getFlangeThick() {
        return flangeThick;
    }

    public void setFlangeThick(Double flangeThick) {
        this.flangeThick = flangeThick;
    }

    public Double getFirstMomentAboutYAxis() {
        return firstMomentAboutYAxis;
    }

    public void setFirstMomentAboutYAxis(Double firstMomentAboutYAxis) {
        this.firstMomentAboutYAxis = firstMomentAboutYAxis;
    }

//    public String getStandard() {
//        return standard;
//    }
//
//    public void setStandard(String standard) {
//        this.standard = standard;
//    }

    public String getProfileNumber() {
        return profileNumber;
    }

    public void setProfileNumber(String number) {
        this.profileNumber = number;
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

