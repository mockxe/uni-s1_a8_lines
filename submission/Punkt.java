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


    public BigDecimal abstand(Punkt other) {
        // sqrt((qx - px)^2 + (qy - py)^2)
        return BigDecimalUtility.sqrt(
                other.x.subtract(this.x).pow(2)
                        .add(other.y.subtract(this.y).pow(2))
        );
    }


    public BigDecimal getX() {
        return x;
    }

    public BigDecimal getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        return  (this == obj
                || (obj instanceof Punkt punkt
                && BigDecimalUtility.equalValues(this.x, punkt.x)
                && BigDecimalUtility.equalValues(this.y, punkt.y))
        );
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

}
