package ua.com.dbncalc.steel.models.sections.with_units;

import lombok.Getter;
import lombok.Setter;
import tech.units.indriya.quantity.Quantities;
import ua.com.dbncalc.steel.models.sections.IBeamRoundedFlangeSection;
import ua.com.dbncalc.steel.services.util.units.quantity.SecondMoment;
import ua.com.dbncalc.steel.services.util.units.quantity.WeightPerLength;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Area;
import javax.measure.quantity.Length;
import javax.measure.quantity.Volume;

@Getter
@Setter
public class IBeamRoundedFlangeSectionWithUnits extends IBeamSectionWithUnits {
    //outside radius (r2) in mm
    private Quantity<Length> outsideRadius;

    public IBeamRoundedFlangeSectionWithUnits() {
    }

    public IBeamRoundedFlangeSectionWithUnits(IBeamRoundedFlangeSection iBeamRoundedFlangeSection,
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
                                 Unit<Length> insideRadiusUnit,
                                 Unit<Length> outsideRadiusUnit) {
        super(iBeamRoundedFlangeSection,
                depthUnit,
                widthUnit,
                areaUnit,
                weightPerLengthUnit,
                secondMomentAboutYAxisUnit,
                secondMomentAboutZAxisUnit,
                sectionModulusAboutYAxisUnit,
                sectionModulusAboutZAxisUnit,
                radiusOfGyrationYAxisUnit,
                radiusOfGyrationZAxisUnit,
                webThickUnit,
                flangeThickUnit,
                firstMomentAboutYAxisUnit,
                insideRadiusUnit);
        this.outsideRadius = Quantities.getQuantity(iBeamRoundedFlangeSection.getOutsideRadius(), outsideRadiusUnit);
    }
}
