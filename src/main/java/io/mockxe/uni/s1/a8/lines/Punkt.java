package io.mockxe.uni.s1.a8.lines;

import java.math.BigDecimal;

public class Punkt {

    private final BigDecimal x;
    private final BigDecimal y;


    public Punkt(BigDecimal x, BigDecimal y) {
        this.x = x;
        this.y = y;
    }

    public Punkt(double x, double y) {
        this(BigDecimal.valueOf(x), BigDecimal.valueOf(y));
    }


    public BigDecimal getX() {
        return x;
    }

    public BigDecimal getY() {
        return y;
    }


    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

}
