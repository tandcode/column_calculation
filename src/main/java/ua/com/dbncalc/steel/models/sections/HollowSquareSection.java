package ua.com.dbncalc.steel.models.sections;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;

@Data
@NoArgsConstructor
@MappedSuperclass
public abstract class HollowSquareSection extends HollowRectangleSection {

    //web thickness (s) in mm
    private Double webThick;

    //inside radius (r1) in mm
    private Double insideRadius;

    {
        //square profile has equal parameters that depends on axes
        setBreadth(getHeight());
        setRadiusOfGyrationZAxis(getRadiusOfGyrationYAxis());
        setSecondMomentAboutZAxis(getSecondMomentAboutYAxis());
        setSectionModulusAboutZAxis(getSectionModulusAboutYAxis());
    }

}
