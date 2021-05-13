package ua.com.dbncalc.steel.models.sections;

import lombok.Data;

// TODO : handle welded beam from form
@Data
public class WeldedIBeamSection extends Section {
    //leg of the weld between web and flange (k) in mm
    private Double legOfWeld;

    //welded beam sheets in mm
    private Double flangeWidth;
    private Double flangeThickness;
    private Double webDepth;
    private Double webThickness;

}
