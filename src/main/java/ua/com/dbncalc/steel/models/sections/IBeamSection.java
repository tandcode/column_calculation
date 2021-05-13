package ua.com.dbncalc.steel.models.sections;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class IBeamSection extends ShapedSection {
    //web thickness (s) in mm
    private Double webThick;

    //flange thickness (t) in mm
    private Double flangeThick;

    //section first moment about Y axis (Sy) in sm^3
    private Double firstMomentAboutYAxis;

    //inside radius (r1) in mm
    private Double insideRadius;
}
