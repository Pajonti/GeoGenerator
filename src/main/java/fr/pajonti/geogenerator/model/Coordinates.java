package fr.pajonti.geogenerator.model;

import java.math.BigDecimal;

public class Coordinates {
    private BigDecimal x;
    private BigDecimal y;

    public Coordinates() {
    }

    public Coordinates(BigDecimal x, BigDecimal y) {
        this.x = x;
        this.y = y;
    }

    public BigDecimal getX() {
        return x;
    }

    public void setX(BigDecimal x) {
        this.x = x;
    }

    public BigDecimal getY() {
        return y;
    }

    public void setY(BigDecimal y) {
        this.y = y;
    }
}
