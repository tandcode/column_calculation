package ua.com.dbncalc.steel.models;

import ua.com.dbncalc.steel.models.sections.Section;
import ua.com.dbncalc.steel.models.sections.ShapedIBeamSection;
import ua.com.dbncalc.steel.models.steels.Steel;

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
        this.section = new ShapedIBeamSection("GOST 8239-89", "20", 26.8);
        this.steel = new Steel("245", 255.0);
    }

    public ColComprWithBuckInput(Section section, Double length, Double estimatedLengthFactor,
                                 Double workingConditionsFactor, Double reliabilityFactorForResponsibility,
                                 Steel steel, Double moment, Double normalForce,
                                 Double traverseForce, Boolean ownWeightIncluded) {
//        TODO : remove hardcode
        this.section = new ShapedIBeamSection("GOST 8239-89", "20", 26.8);
        this.length = length;
        this.estimatedLengthFactor = estimatedLengthFactor;
        this.workingConditionsFactor = workingConditionsFactor;
        this.reliabilityFactorForResponsibility = reliabilityFactorForResponsibility;
        //        TODO : remove hardcode
        this.steel = new Steel("245", 255.0);
        this.moment = moment;
        this.normalForce = normalForce;
        this.traverseForce = traverseForce;
        this.ownWeightIncluded = ownWeightIncluded;
    }

    public int getId() {
        return id;
    }

    public Section getSection() {
        return section;
    }

    public Double getLength() {
        return length;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public void setEstimatedLengthFactor(Double estimatedLengthFactor) {
        this.estimatedLengthFactor = estimatedLengthFactor;
    }

    public void setWorkingConditionsFactor(Double workingConditionsFactor) {
        this.workingConditionsFactor = workingConditionsFactor;
    }

    public void setReliabilityFactorForResponsibility(Double reliabilityFactorForResponsibility) {
        this.reliabilityFactorForResponsibility = reliabilityFactorForResponsibility;
    }

    public void setSteel(Steel steel) {
        this.steel = steel;
    }

    public void setMoment(Double moment) {
        this.moment = moment;
    }

    public void setNormalForce(Double normalForce) {
        this.normalForce = normalForce;
    }

    public void setTraverseForce(Double traverseForce) {
        this.traverseForce = traverseForce;
    }

    public void setOwnWeightIncluded(Boolean ownWeightIncluded) {
        this.ownWeightIncluded = ownWeightIncluded;
    }

    public Double getEstimatedLengthFactor() {
        return estimatedLengthFactor;
    }

    public Double getWorkingConditionsFactor() {
        return workingConditionsFactor;
    }

    public Double getReliabilityFactorForResponsibility() {
        return reliabilityFactorForResponsibility;
    }

    public Steel getSteel() {
        return steel;
    }

    public Double getMoment() {
        return moment;
    }

    public Double getNormalForce() {
        return normalForce;
    }

    public Double getTraverseForce() {
        return traverseForce;
    }

    public Boolean getOwnWeightIncluded() {
        return ownWeightIncluded;
    }
}
