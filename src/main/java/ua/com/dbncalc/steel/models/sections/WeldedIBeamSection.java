package ua.com.dbncalc.steel.models.sections;

public class WeldedIBeamSection extends IBeamSection {

    //leg of the weld between web and flange (k) in mm
    private Double legOfWeld;

    public Double getLegOfWeld() {
        return legOfWeld;
    }

    public void setLegOfWeld(Double legOfWeld) {
        this.legOfWeld = legOfWeld;
    }

}
