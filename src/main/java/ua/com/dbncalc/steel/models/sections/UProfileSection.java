package ua.com.dbncalc.steel.models.sections;

public class UProfileSection extends Section {

    //web thickness (s) in mm
    private Double webThick;

    //flange thickness (t) in mm
    private Double flangeThick;

    //inside radius (r1) in mm
    private Double insideRadius;

    //outside radius (r2) in mm
    private Double outsideRadius;

    //section first moment about Y axis (Sy) in sm^3
    private Double firstMomentAboutYAxis;

    //section length to center of the weight (y0) in mm
    private Double lengthToCenterOfTheWeight;

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

    public Double getFirstMomentAboutYAxis() {
        return firstMomentAboutYAxis;
    }

    public void setFirstMomentAboutYAxis(Double firstMomentAboutYAxis) {
        this.firstMomentAboutYAxis = firstMomentAboutYAxis;
    }

    public Double getLengthToCenterOfTheWeight() {
        return lengthToCenterOfTheWeight;
    }

    public void setLengthToCenterOfTheWeight(Double lengthToCenterOfTheWeight) {
        this.lengthToCenterOfTheWeight = lengthToCenterOfTheWeight;
    }
}
