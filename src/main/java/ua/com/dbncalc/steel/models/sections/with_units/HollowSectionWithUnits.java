package ua.com.dbncalc.steel.models.sections.with_units;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.units.indriya.quantity.Quantities;
import ua.com.dbncalc.steel.models.sections.HollowSection;
import ua.com.dbncalc.steel.models.sections.ShapedSection;
import ua.com.dbncalc.steel.services.util.units.quantity.SecondMoment;
import ua.com.dbncalc.steel.services.util.units.quantity.WeightPerLength;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Area;
import javax.measure.quantity.Length;
import javax.measure.quantity.Volume;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Getter
@Setter
public class HollowSectionWithUnits extends ShapedSectionWithUnits {

    //web thickness (s) in mm
    private Quantity<Length> webThick;

    //inside radius (r1) in mm
    private Quantity<Length> insideRadius;

    public HollowSectionWithUnits() {
    }

    public HollowSectionWithUnits(HollowSection hollowSection,
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
                                  Unit<Length> insideRadiusUnit) {
        super(hollowSection,
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
        this.webThick = Quantities.getQuantity(hollowSection.getWebThick(), webThickUnit);
        this.insideRadius = Quantities.getQuantity(hollowSection.getInsideRadius(), insideRadiusUnit);
    }
}
