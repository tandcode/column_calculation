package ua.com.dbncalc.steel.models.sections;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)

@SuperBuilder
@AllArgsConstructor
public class IBeamSection extends ShapedSection {
    //web thickness (s) in mm
    private Double webThick;
    // TODO: 15.08.2021 implement webbed and flanged superclasses
    //flange thickness (t) in mm
    private Double flangeThick;

    //section first moment about Y axis (Sy) in sm^3
    private Double firstMomentAboutYAxis;

    //inside radius (r1) in mm
    private Double insideRadius;
}
