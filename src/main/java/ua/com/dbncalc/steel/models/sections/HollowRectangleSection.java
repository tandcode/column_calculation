package ua.com.dbncalc.steel.models.sections;

public class HollowRectangleSection extends Section {

    //web thickness (s) in mm
    private Double webThick;

    //inside radius (r1) in mm
    private Double insideRadius;

    public Double getWebThick() {
        return webThick;
    }

    public void setWebThick(Double webThick) {
        this.webThick = webThick;
    }

    public Double getInsideRadius() {
        return insideRadius;
    }

    public void setInsideRadius(Double insideRadius) {
        this.insideRadius = insideRadius;
    }

}
