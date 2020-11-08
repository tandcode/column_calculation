package ua.com.dbncalc.steel.services;

public class Table8_1Entity {
    private Double alpha;

    public Table8_1Entity(Double alpha, Double beta) {
        this.alpha = alpha;
        this.beta = beta;
    }

    private Double beta;

    public Double getAlpha() {
        return alpha;
    }

    public void setAlpha(Double alpha) {
        this.alpha = alpha;
    }

    public Double getBeta() {
        return beta;
    }

    public void setBeta(Double beta) {
        this.beta = beta;
    }
}