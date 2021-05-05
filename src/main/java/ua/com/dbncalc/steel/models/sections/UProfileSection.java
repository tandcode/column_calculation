package ua.com.dbncalc.steel.models.sections;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;

@Data
@NoArgsConstructor
@MappedSuperclass
public abstract class UProfileSection extends Section {

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
