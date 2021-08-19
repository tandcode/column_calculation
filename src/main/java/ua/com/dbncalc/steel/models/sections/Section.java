package ua.com.dbncalc.steel.models.sections;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
@Data
@MappedSuperclass
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
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
