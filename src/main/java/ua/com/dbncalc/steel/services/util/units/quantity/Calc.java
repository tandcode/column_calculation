package ua.com.dbncalc.steel.services.util.units.quantity;

import tech.units.indriya.ComparableQuantity;
import tech.units.indriya.quantity.Quantities;

import javax.measure.Quantity;
import javax.measure.Unit;
import java.util.Objects;

public abstract class Calc {
    public static ComparableQuantity<?> pow(Quantity<?> quantity , int exponent) {
        Objects.requireNonNull(quantity);
        Objects.requireNonNull(exponent);

        Number value = quantity.getValue();
        value = Math.pow(value.doubleValue(), exponent);
        Unit<?> unit = quantity.getUnit();
        unit = unit.pow(exponent);
        return Quantities.getQuantity(value, unit);
    }

    public static ComparableQuantity<?> sqrt(Quantity<?> quantity) {
        Objects.requireNonNull(quantity);

        Number value = quantity.getValue();
        value = Math.sqrt(value.doubleValue());
        Unit<?> unit = quantity.getUnit();
        unit = unit.root(2);
        return Quantities.getQuantity(value, unit);
    }
}
