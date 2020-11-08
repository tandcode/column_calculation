package ua.com.dbncalc.steel.models.steels;

public class Steel {

    //steel grade
    private String grade;

    //minimal thickness of the steel profile in mm
    private Double steelThickLowLim;

    //maximal thickness of the steel profile in mm
    private Double steelThickUppLim;

    //characteristic yield strange of steel sheets (Ryn) in N/mm^2
    private Double charYieldStrangeSheet;

    //characteristic ultimate strange of steel sheets (Run) in N/mm^2
    private Double charUltimateStrangeSheet;

    //characteristic yield strange of shaped profiles (Ryn) in N/mm^2
    private Double charYieldStrangeShape;

    //characteristic ultimate strange of shaped profiles (Run) in N/mm^2
    private Double charUltimateStrangeShape;

    //design yield strange of steel sheets (Ry) in N/mm^2
    private Double designYieldStrangeSheet;

    //design ultimate strange of steel sheets (Ru) in N/mm^2
    private Double designUltimateStrangeSheet;

    //design yield strange of shaped profiles (Ry) in N/mm^2
    private Double designYieldStrangeShape;

    //design ultimate strange of shaped profiles (Ru) in N/mm^2
    private Double designUltimateStrangeShape;

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Double getSteelThickLowLim() {
        return steelThickLowLim;
    }

    public void setSteelThickLowLim(Double steelThickLowLim) {
        this.steelThickLowLim = steelThickLowLim;
    }

    public Double getSteelThickUppLim() {
        return steelThickUppLim;
    }

    public void setSteelThickUppLim(Double steelThickUppLim) {
        this.steelThickUppLim = steelThickUppLim;
    }

    public Double getCharYieldStrangeSheet() {
        return charYieldStrangeSheet;
    }

    public void setCharYieldStrangeSheet(Double charYieldStrangeSheet) {
        this.charYieldStrangeSheet = charYieldStrangeSheet;
    }

    public Double getCharUltimateStrangeSheet() {
        return charUltimateStrangeSheet;
    }

    public void setCharUltimateStrangeSheet(Double charUltimateStrangeSheet) {
        this.charUltimateStrangeSheet = charUltimateStrangeSheet;
    }

    public Double getCharYieldStrangeShape() {
        return charYieldStrangeShape;
    }

    public void setCharYieldStrangeShape(Double charYieldStrangeShape) {
        this.charYieldStrangeShape = charYieldStrangeShape;
    }

    public Double getCharUltimateStrangeShape() {
        return charUltimateStrangeShape;
    }

    public void setCharUltimateStrangeShape(Double charUltimateStrangeShape) {
        this.charUltimateStrangeShape = charUltimateStrangeShape;
    }

    public Double getDesignYieldStrangeSheet() {
        return designYieldStrangeSheet;
    }

    public void setDesignYieldStrangeSheet(Double designYieldStrangeSheet) {
        this.designYieldStrangeSheet = designYieldStrangeSheet;
    }

    public Double getDesignUltimateStrangeSheet() {
        return designUltimateStrangeSheet;
    }

    public void setDesignUltimateStrangeSheet(Double designUltimateStrangeSheet) {
        this.designUltimateStrangeSheet = designUltimateStrangeSheet;
    }

    public Double getDesignYieldStrangeShape() {
        return designYieldStrangeShape;
    }

    public Steel() {
    }

    public Steel(Double designYieldStrangeShape) {
        this.designYieldStrangeShape = designYieldStrangeShape;
    }

    public void setDesignYieldStrangeShape(Double designYieldStrangeShape) {
        this.designYieldStrangeShape = designYieldStrangeShape;
    }

    public Double getDesignUltimateStrangeShape() {
        return designUltimateStrangeShape;
    }

    public void setDesignUltimateStrangeShape(Double designUltimateStrangeShape) {
        this.designUltimateStrangeShape = designUltimateStrangeShape;
    }
}
