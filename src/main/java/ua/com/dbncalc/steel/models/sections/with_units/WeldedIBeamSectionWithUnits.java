package ua.com.dbncalc.steel.models.sections.with_units;

import lombok.Getter;
import lombok.Setter;

import javax.measure.Quantity;
import javax.measure.quantity.Length;

@Getter
@Setter
public class WeldedIBeamSectionWithUnits extends SectionWithUnits {
    //leg of the weld between web and flange (k) in mm
    private Quantity<Length> legOfWeld;

    //welded beam sheets in mm
    private Quantity<Length> flangeWidth;
    private Quantity<Length> flangeThick;
    private Quantity<Length> webDepth;
    private Quantity<Length> webThick;
}
