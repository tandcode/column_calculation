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
public class UProfileSection extends ShapedSection {

    //web thickness (s) in mm
    private Double webThick;

    //flange thickness (t) in mm
    private Double flangeThick;

    //inside radius (r1) in mm
    private Double insideRadius;

    //outside radius (r2) in mm
    private Double outsideRadius;

    //section first moment about Y axis (Sy) in sm^3
    private Double firstMomentAboutYAxis;

    //section length to center of the weight (y0) in mm
    private Double lengthToCenterOfTheWeight;
}
