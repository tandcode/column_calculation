package ua.com.dbncalc.steel.models.sections;

import lombok.Data;
import ua.com.dbncalc.steel.services.util.units.quantity.RadiusOfGyration;
import ua.com.dbncalc.steel.services.util.units.quantity.SecondMoment;
import ua.com.dbncalc.steel.services.util.units.quantity.SectionModulus;
import ua.com.dbncalc.steel.services.util.units.quantity.WeightPerLength;

import javax.measure.Quantity;
import javax.measure.quantity.Area;
import javax.measure.quantity.Length;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
@Data
@MappedSuperclass
public class Section {
    //section depth (h) in mm
    private Double depth;

    //section width (b) in mm
    private Double width;

    //section area (A) in sm^2
    private Double area;

    //section weight per length (P) in kg/m
    private Double weightPerLength;

    //section second moment about Y axis (Iy) in sm^4
    private Double secondMomentAboutYAxis;

    //section second moment about Z axis (Iz) in sm^4
    private Double secondMomentAboutZAxis;

    //section modulus about Y axis (Wy) in sm^3
    private Double sectionModulusAboutYAxis;

    //section modulus about Z axis (Wz) in sm^3
    private Double sectionModulusAboutZAxis;

    //section radius of gyration Y axis (iy) in mm
    private Double radiusOfGyrationYAxis;

    //section radius of gyration Z axis (iz) in mm
    private Double radiusOfGyrationZAxis;

    @Enumerated(EnumType.STRING)
    private SectionType sectionType;

    public enum SectionType {
        I_BEAM,
        WELDED_I_BEAM,
        HOLLOW,
        U_PROFILE
    }
}
