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
public class HollowSection extends ShapedSection {

    //web thickness (s) in mm
    private Double webThick;

    //inside radius (r1) in mm
    private Double insideRadius;

}
