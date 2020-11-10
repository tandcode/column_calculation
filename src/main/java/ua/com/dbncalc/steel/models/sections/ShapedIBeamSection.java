package ua.com.dbncalc.steel.models.sections;

import javax.persistence.Entity;

public abstract class ShapedIBeamSection extends IBeamSection {

    //inside radius (r1) in mm
    private Double insideRadius;

    //outside radius (r2) in mm
    private Double outsideRadius;

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


    public ShapedIBeamSection() {
    }

    public ShapedIBeamSection(String number, Double area) {
        super(number, area);
    }
}
