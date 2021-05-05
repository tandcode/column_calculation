package ua.com.dbncalc.steel.models.sections;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;

@Data
@NoArgsConstructor
@MappedSuperclass
public abstract class IBeamRoundedFlangeSection extends IBeamSection{
    //inside radius (r1) in mm
    private Double insideRadius;

    //outside radius (r2) in mm
    private Double outsideRadius;
}
