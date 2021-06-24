package ua.com.dbncalc.steel.services.util.units;

import static tech.units.indriya.unit.Units.*;

import tech.units.indriya.AbstractSystemOfUnits;
import tech.units.indriya.AbstractUnit;
import tech.units.indriya.ComparableQuantity;
import tech.units.indriya.format.SimpleUnitFormat;
import tech.units.indriya.quantity.Quantities;
import ua.com.dbncalc.steel.services.util.units.quantity.*;

import javax.measure.MetricPrefix;
import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.*;
import javax.measure.spi.SystemOfUnits;

public class StructuralUnits extends AbstractSystemOfUnits {
    private static final String SYSTEM_NAME = "Structural Units";

    private static final int STANDARD_GRAVITY_DIVIDEND = 980665;

    private static final int STANDARD_GRAVITY_DIVISOR = 100000;

    public static final ComparableQuantity<Acceleration> STANDARD_GRAVITY = Quantities.getQuantity(
            STANDARD_GRAVITY_DIVIDEND / STANDARD_GRAVITY_DIVISOR,
            METRE.divide(SECOND.pow(2)).asType(Acceleration.class));

    private static final StructuralUnits INSTANCE = new StructuralUnits();

    private StructuralUnits(){}

    public static SystemOfUnits getInstance() {
        return INSTANCE;
    }

    public static final Unit<Mass> TONNE = addUnit(KILOGRAM.multiply(1000), "t");

    public static final Unit<Force> KILONEWTON = addUnit(MetricPrefix.KILO(NEWTON));
    public static final Unit<Force> TON_FORCE = addUnit(KILONEWTON.multiply(STANDARD_GRAVITY_DIVIDEND).divide(STANDARD_GRAVITY_DIVISOR), "tf");

    public static final Unit<Pressure> KILOPASCAL = addUnit(MetricPrefix.KILO(PASCAL));
    public static final Unit<Pressure> MEGAPASCAL = addUnit(MetricPrefix.MEGA(PASCAL));
    public static final Unit<Pressure> TON_FORCE_PER_SQUARE_METER = addUnit(TON_FORCE.divide(SQUARE_METRE).asType(Pressure.class));

    public static final Unit<Length> MILLIMETRE = addUnit(MetricPrefix.MILLI(METRE));
    public static final Unit<Length> CENTIMETRE = addUnit(MetricPrefix.CENTI(METRE));

    public static final Unit<Area> SQUARE_CENTIMETRE = addUnit(MetricPrefix.CENTI(METRE).pow(2).asType(Area.class));

    public static final Unit<WeightPerLength> KILOGRAM_PER_METRE = addUnit(KILOGRAM.divide(METRE).asType(WeightPerLength.class));

    public static final Unit<Moment> KILONEWTON_METRE = addUnit(KILONEWTON.multiply(METRE).asType(Moment.class));
    public static final Unit<Moment> TON_FORCE_METRE = addUnit(TON_FORCE.multiply(METRE).asType(Moment.class));

    public static final Unit<SecondMoment> CENTIMETRE_TO_THE_FOURTH = addUnit(CENTIMETRE.pow(4).asType(SecondMoment.class));
    public static final Unit<Volume> CENTIMETRE_TO_THE_THIRD = addUnit(CENTIMETRE.pow(3).asType(Volume.class));

    public static final Unit<Density> KILOGRAM_PER_CUBIC_METRE = addUnit(KILOGRAM.divide(METRE.pow(3)).asType(Density.class));
    public static final Unit<Density> TONNE_PER_CUBIC_METRE = addUnit(TONNE.divide(METRE.pow(3)).asType(Density.class));

    /**
     * Adds a new unit not mapped to any specified quantity type.
     *
     * @param unit
     *            the unit being added.
     * @return <code>unit</code>.
     */
    private static <U extends Unit<?>> U addUnit(U unit) {
        INSTANCE.units.add(unit);
        return unit;
    }

    /**
     * Adds a new unit not mapped to any specified quantity type and puts a text
     * as symbol or label.
     *
     * @param unit
     *            the unit being added.
     * @param name
     *            the string to use as name
     * @param text
     *            the string to use as label or symbol
     * @param isLabel
     *            if the string should be used as a label or not
     * @return <code>unit</code>.
     */
    private static <U extends Unit<?>> U addUnit(U unit, String name, String text, boolean isLabel) {
        if (isLabel) {
            SimpleUnitFormat.getInstance().label(unit, text);
        }
        if (name != null && unit instanceof AbstractUnit) {
            return Helper.addUnit(INSTANCE.units, unit, name);
        } else {
            INSTANCE.units.add(unit);
        }
        return unit;
    }

    /**
     * Adds a new unit not mapped to any specified quantity type and puts a text
     * as symbol or label.
     *
     * @param unit
     *            the unit being added.
     * @param name
     *            the string to use as name
     * @param label
     *            the string to use as label
     * @return <code>unit</code>.
     */
    private static <U extends Unit<?>> U addUnit(U unit, String name, String label) {
        return addUnit(unit, name, label, true);
    }

    /**
     * Adds a new unit not mapped to any specified quantity type and puts a text
     * as symbol or label.
     *
     * @param unit
     *            the unit being added.
     * @param text
     *            the string to use as label or symbol
     * @param isLabel
     *            if the string should be used as a label or not
     * @return <code>unit</code>.
     */
    private static <U extends Unit<?>> U addUnit(U unit, String text, boolean isLabel) {
        return addUnit(unit, null, text, isLabel);
    }

    /**
     * Adds a new unit not mapped to any specified quantity type and puts a text
     * as label.
     *
     * @param unit
     *            the unit being added.
     * @param text
     *            the string to use as label or symbol
     * @return <code>unit</code>.
     */
    private static <U extends Unit<?>> U addUnit(U unit, String text) {
        return addUnit(unit, null, text, true);
    }

    @Override
    public String getName() {
        return SYSTEM_NAME;
    }

}
