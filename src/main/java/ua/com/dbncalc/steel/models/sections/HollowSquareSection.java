package ua.com.dbncalc.steel.models.sections;

import javax.persistence.Entity;

@Entity
public class HollowSquareSection extends HollowRectangleSection {

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

    {
        //square profile has equal parameters that depends on axes
        setBreadth(getHeight());
        setRadiusOfGyrationZAxis(getRadiusOfGyrationYAxis());
        setSecondMomentAboutZAxis(getSecondMomentAboutYAxis());
        setSectionModulusAboutZAxis(getSectionModulusAboutYAxis());
    }


}
