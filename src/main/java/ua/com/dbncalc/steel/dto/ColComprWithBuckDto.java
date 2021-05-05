package ua.com.dbncalc.steel.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ColComprWithBuckDto {

    private Integer id;
    private String sectionType;
    private String sectionStandard;
    private String sectionNumber;

    //element length in m
    private Double length;
    //estimated length factor
    private Double estimatedLengthFactor;
    //working conditions factor (gammaC)
    private Double workingConditionsFactor;
    //reliability factor for responsibility(gammaN)
    private Double reliabilityFactorForResponsibility;
    //steel class name
    private String steel;
    //calculation moment (M) in t*m
    private Double moment;
    //normal force (N) in t
    private Double normalForce;
    //traverse force (Q) in t
    private Double traverseForce;
    //own weight included
    private Boolean ownWeightIncluded;

}
