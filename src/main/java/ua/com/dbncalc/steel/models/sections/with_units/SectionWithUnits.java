package ua.com.dbncalc.steel.models.sections.with_units;

import lombok.Getter;
import lombok.Setter;
import tech.units.indriya.quantity.Quantities;
import ua.com.dbncalc.steel.models.sections.Section;
import ua.com.dbncalc.steel.services.util.units.quantity.SecondMoment;
import ua.com.dbncalc.steel.services.util.units.quantity.WeightPerLength;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Area;
import javax.measure.quantity.Length;
import javax.measure.quantity.Volume;

@Getter
@Setter
public class SectionWithUnits {
    //section depth (h) in mm
    private Quantity<Length> depth;

    //section width (b) in mm
    private Quantity<Length> width;

    //section area (A) in sm^2
    private Quantity<Area> area;

    //section weight per length (P) in kg/m
    private Quantity<WeightPerLength> weightPerLength;

    //section second moment about Y axis (Iy) in sm^4
    private Quantity<SecondMoment> secondMomentAboutYAxis;

    //section second moment about Z axis (Iz) in sm^4
    private Quantity<SecondMoment> secondMomentAboutZAxis;

    //section modulus about Y axis (Wy) in sm^3
    private Quantity<Volume> sectionModulusAboutYAxis;

    //section modulus about Z axis (Wz) in sm^3
    private Quantity<Volume> sectionModulusAboutZAxis;

    //section radius of gyration Y axis (iy) in mm
    private Quantity<Length> radiusOfGyrationYAxis;

    //section radius of gyration Z axis (iz) in mm
    private Quantity<Length> radiusOfGyrationZAxis;

    public SectionWithUnits() {
    }

    public SectionWithUnits(Section section,
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
        this.depth = Quantities.getQuantity(section.getDepth(), depthUnit);
        this.width = Quantities.getQuantity(section.getWidth(), widthUnit);
        this.area = Quantities.getQuantity(section.getArea(), areaUnit);
        this.weightPerLength = Quantities.getQuantity(section.getWeightPerLength(), weightPerLengthUnit);
        this.secondMomentAboutYAxis = Quantities.getQuantity(section.getSecondMomentAboutYAxis(), secondMomentAboutYAxisUnit);
        this.secondMomentAboutZAxis = Quantities.getQuantity(section.getSecondMomentAboutZAxis(), secondMomentAboutZAxisUnit);
        this.sectionModulusAboutYAxis = Quantities.getQuantity(section.getSectionModulusAboutYAxis(), sectionModulusAboutYAxisUnit);
        this.sectionModulusAboutZAxis = Quantities.getQuantity(section.getSectionModulusAboutZAxis(), sectionModulusAboutZAxisUnit);
        this.radiusOfGyrationYAxis = Quantities.getQuantity(section.getRadiusOfGyrationYAxis(), radiusOfGyrationYAxisUnit);
        this.radiusOfGyrationZAxis = Quantities.getQuantity(section.getRadiusOfGyrationZAxis(), radiusOfGyrationZAxisUnit);
    }
}
