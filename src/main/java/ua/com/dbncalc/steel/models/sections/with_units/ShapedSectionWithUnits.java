package ua.com.dbncalc.steel.models.sections.with_units;

import lombok.Getter;
import lombok.Setter;
import ua.com.dbncalc.steel.models.sections.ShapedSection;
import ua.com.dbncalc.steel.services.util.units.quantity.SecondMoment;
import ua.com.dbncalc.steel.services.util.units.quantity.WeightPerLength;

import javax.measure.Unit;
import javax.measure.quantity.Area;
import javax.measure.quantity.Length;
import javax.measure.quantity.Volume;

@Getter
@Setter
public class ShapedSectionWithUnits extends SectionWithUnits {
    private Integer id;

    private String standard;

    //profile number(identifier)
    private String profileNumber;

    public ShapedSectionWithUnits() {
    }

    public ShapedSectionWithUnits(ShapedSection shapedSection,
                                  Unit<Length> depthUnit,
                                  Unit<Length> widthUnit,
                                  Unit<Area> areaUnit,
                                  Unit<WeightPerLength> weightPerLengthUnit,
                                  Unit<SecondMoment> secondMomentAboutYAxisUnit,
                                  Unit<SecondMoment> secondMomentAboutZAxisUnit,
                                  Unit<Volume> sectionModulusAboutYAxisUnit,
                                  Unit<Volume> sectionModulusAboutZAxisUnit,
                                  Unit<Length> radiusOfGyrationYAxisUnit,
                                  Unit<Length> radiusOfGyrationZAxisUnit) {
        super(shapedSection,
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
        this.id = shapedSection.getId();
        this.standard = shapedSection.getStandard();
        this.profileNumber = shapedSection.getProfileNumber();
    }
}
