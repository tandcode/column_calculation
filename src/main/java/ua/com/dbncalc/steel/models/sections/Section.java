package ua.com.dbncalc.steel.models.sections;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@NoArgsConstructor
@MappedSuperclass
public abstract class Section {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    //profile number(identifier)
    private String profileNumber;

    //section height (h) in mm
    private Double height;

    //section breadth (b) in mm
    private Double breadth;

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

}
