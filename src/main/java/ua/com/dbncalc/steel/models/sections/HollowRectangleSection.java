package ua.com.dbncalc.steel.models.sections;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;

@Data
@NoArgsConstructor
@MappedSuperclass
public abstract class HollowRectangleSection extends Section {

    //web thickness (s) in mm
    private Double webThick;

    //inside radius (r1) in mm
    private Double insideRadius;

}
