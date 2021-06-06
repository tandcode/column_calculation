package ua.com.dbncalc.steel.models.sections.with_units;

import lombok.Getter;
import lombok.Setter;
import tech.units.indriya.quantity.Quantities;
import ua.com.dbncalc.steel.models.sections.UProfileSection;
import ua.com.dbncalc.steel.services.util.units.quantity.SecondMoment;
import ua.com.dbncalc.steel.services.util.units.quantity.WeightPerLength;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Area;
import javax.measure.quantity.Length;
import javax.measure.quantity.Volume;

@Getter
@Setter
public class UProfileSectionWithUnits extends ShapedSectionWithUnits {
    //web thickness (s) in mm
    private Quantity<Length> webThick;

    //flange thickness (t) in mm
    private Quantity<Length> flangeThick;

    //inside radius (r1) in mm
    private Quantity<Length> insideRadius;

    //outside radius (r2) in mm
    private Quantity<Length> outsideRadius;

    //section first moment about Y axis (Sy) in sm^3
    private Quantity<Volume> firstMomentAboutYAxis;

    //section length to center of the weight (y0) in mm
    private Quantity<Length> centerOfTheWeight;

    public UProfileSectionWithUnits() {
    }

    public UProfileSectionWithUnits(UProfileSection uProfileSection,
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
                                    Unit<Length> insideRadiusUnit,
                                    Unit<Length> outsideRadiusUnit,
                                    Unit<Volume> firstMomentAboutYAxisUnit,
                                    Unit<Length> centerOfTheWeightUnit) {
        super(uProfileSection,
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
        this.webThick = Quantities.getQuantity(uProfileSection.getWebThick(), webThickUnit);
        this.flangeThick = Quantities.getQuantity(uProfileSection.getFlangeThick(), flangeThickUnit);
        this.insideRadius = Quantities.getQuantity(uProfileSection.getInsideRadius(), insideRadiusUnit);
        this.outsideRadius = Quantities.getQuantity(uProfileSection.getOutsideRadius(), outsideRadiusUnit);
        this.firstMomentAboutYAxis = Quantities.getQuantity(uProfileSection.getFirstMomentAboutYAxis(), firstMomentAboutYAxisUnit);
        this.centerOfTheWeight = Quantities.getQuantity(uProfileSection.getCenterOfTheWeight(), centerOfTheWeightUnit);
    }
}
