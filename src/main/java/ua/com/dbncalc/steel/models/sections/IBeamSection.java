package ua.com.dbncalc.steel.models.sections;

public abstract class IBeamSection extends Section{
    //web thickness (s) in mm
    private Double webThick;

    //flange thickness (t) in mm
    private Double flangeThick;

    //section first moment about Y axis (Sy) in sm^3
    private Double firstMomentAboutYAxis;

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

    public IBeamSection() {
    }

    public IBeamSection(String number, Double area) {
        super(number, area);
    }
}
