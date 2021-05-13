package ua.com.dbncalc.steel.models;

import lombok.Data;
import ua.com.dbncalc.steel.models.sections.Section;
import ua.com.dbncalc.steel.models.sections.ShapedSection;
import ua.com.dbncalc.steel.models.steels.Steel;

@Data
public class ColComprWithBuckInput {

    private int id;

    private Section section;

    //element length in m
    private Double length;
    //estimated length factor
    private Double estimatedLengthFactor;
    //working conditions factor (gammaC)
    private Double workingConditionsFactor;
    //reliability factor for responsibility(gammaN)
    private Double reliabilityFactorForResponsibility;
    // TODO : handle the steel field
    private Steel steel;
    //calculation moment (M) in t*m
    private Double moment;
    //normal force (N) in t
    private Double normalForce;
    //traverse force (Q) in t
    private Double traverseForce;
    //own weight included
    private Boolean ownWeightIncluded;

    //        TODO : remove hardcode
    public ColComprWithBuckInput() {
        this.steel = new Steel(255.0);
    }

    public ColComprWithBuckInput(Section section, Double length, Double estimatedLengthFactor,
                                 Double workingConditionsFactor, Double reliabilityFactorForResponsibility,
                                 Steel steel, Double moment, Double normalForce,
                                 Double traverseForce, Boolean ownWeightIncluded) {
        this.length = length;
        this.estimatedLengthFactor = estimatedLengthFactor;
        this.workingConditionsFactor = workingConditionsFactor;
        this.reliabilityFactorForResponsibility = reliabilityFactorForResponsibility;
        //        TODO : remove hardcode
        this.steel = new Steel(255.0);
        this.moment = moment;
        this.normalForce = normalForce;
        this.traverseForce = traverseForce;
        this.ownWeightIncluded = ownWeightIncluded;
    }

}
