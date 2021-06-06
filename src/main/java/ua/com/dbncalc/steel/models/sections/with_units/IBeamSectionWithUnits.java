package ua.com.dbncalc.steel.models.sections.with_units;

import lombok.Getter;
import lombok.Setter;
import tech.units.indriya.quantity.Quantities;
import ua.com.dbncalc.steel.models.sections.HollowSection;
import ua.com.dbncalc.steel.models.sections.IBeamSection;
import ua.com.dbncalc.steel.services.util.units.quantity.SecondMoment;
import ua.com.dbncalc.steel.services.util.units.quantity.WeightPerLength;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Area;
import javax.measure.quantity.Length;
import javax.measure.quantity.Volume;

@Getter
@Setter
public class IBeamSectionWithUnits extends ShapedSectionWithUnits {
    //web thickness (s) in mm
    private Quantity<Length> webThick;

    //flange thickness (t) in mm
    private Quantity<Length> flangeThick;

    //section first moment about Y axis (Sy) in sm^3
    private Quantity<Volume> firstMomentAboutYAxis;

    //inside radius (r1) in mm
    private Quantity<Length> insideRadius;

    public IBeamSectionWithUnits() {
    }

    public IBeamSectionWithUnits(IBeamSection iBeamSection,
                                 Unit<Length> depthUnit,
                                 Unit<Length> widthUnit,
                                 Unit<Area> areaUnit,
                                 Unit<WeightPerLength> weightPerLengthUnit,
                                 Unit<SecondMoment> secondMomentAboutYAxisUnit,
                                 Unit<SecondMoment> secondMomentAboutZAxisUnit,
                                 Unit<Volume> sectionModulusAboutYAxisUnit,
                                 Unit<Volume> sectionModulusAboutZAxisUnit,
                                 Unit<Length> radiusOfGyrationYAxisUnit,
                                 Unit<Length> radiusOfGyrationZAxisUnit,
                                 Unit<Length> webThickUnit,
                                 Unit<Length> flangeThickUnit,
                                 Unit<Volume> firstMomentAboutYAxisUnit,
                                 Unit<Length> insideRadiusUnit) {
        super(iBeamSection,
                depthUnit,
                widthUnit,
                areaUnit,
                weightPerLengthUnit,
                secondMomentAboutYAxisUnit,
                secondMomentAboutZAxisUnit,
                sectionModulusAboutYAxisUnit,
                sectionModulusAboutZAxisUnit,
                radiusOfGyrationYAxisUnit,
                radiusOfGyrationZAxisUnit);
        this.webThick = Quantities.getQuantity(iBeamSection.getWebThick(), webThickUnit);
        this.flangeThick = Quantities.getQuantity(iBeamSection.getFlangeThick(), flangeThickUnit);
        this.firstMomentAboutYAxis = Quantities.getQuantity(iBeamSection.getFirstMomentAboutYAxis(), firstMomentAboutYAxisUnit);
        this.insideRadius = Quantities.getQuantity(iBeamSection.getInsideRadius(), insideRadiusUnit);
    }
}
