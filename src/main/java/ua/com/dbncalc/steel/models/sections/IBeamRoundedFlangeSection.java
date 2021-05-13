package ua.com.dbncalc.steel.models.sections;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class IBeamRoundedFlangeSection extends IBeamSection{
    //outside radius (r2) in mm
    private Double outsideRadius;
}
