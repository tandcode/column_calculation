package ua.com.dbncalc.steel.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class CCWBInput {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String sectionType;
    private String sectionStandard;
    private String sectionNumber;

    //optional welded beam params
    private Double flangeWidth;
    private Double flangeThickness;
    private Double webDepth;
    private Double webThickness;
    private Double legOfWeld;

    //element length in m
    @NotNull(message = "errors.null.length")
    @DecimalMin(value = "0.0", inclusive = false, message = "errors.min.length")
    private Double length;

    //effective length factor Y axes
    @NotNull(message = "errors.null.effectiveLengthFactorY")
    @DecimalMin(value = "0.0", inclusive = false, message = "errors.min.effectiveLengthFactorY")
    private Double effectiveLengthFactorY;

    //effective length factor Z axes
    @NotNull(message = "errors.null.effectiveLengthFactorZ")
    @DecimalMin(value = "0.0", inclusive = false, message = "errors.min.effectiveLengthFactorZ")
    private Double effectiveLengthFactorZ;

    //working conditions factor (gammaC)
    @NotNull(message = "errors.null.workingConditionsFactor")
    @DecimalMin(value = "0.75", message = "errors.min.workingConditionsFactor")
    @DecimalMax(value = "1.2", message = "errors.max.workingConditionsFactor")
    private Double workingConditionsFactor;

    //reliability factor for responsibility(gammaN)
    @NotNull(message = "errors.null.reliabilityFactorForResponsibility")
    @DecimalMin(value = "0.9", message = "errors.min.reliabilityFactorForResponsibility")
    @DecimalMax(value = "1.25", message = "errors.max.reliabilityFactorForResponsibility")
    private Double reliabilityFactorForResponsibility;

    //steel class name
    private String steel;
    //calculation moment (M) in t*m
    private Double moment;
    //normal force (N) in t
    @NotNull(message = "errors.null.normalForce")
    private Double normalForce;
    //traverse force (Q) in t
    private Double traverseForce;
    //own weight included
    private Boolean ownWeightIncluded;
    @Column(nullable = false)
    private Boolean isSaved = false;
}
