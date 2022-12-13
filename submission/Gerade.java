import java.math.BigDecimal;

sealed class Gerade permits Strahl {

    private final Punkt p1;
    private final Punkt p2;


    public Gerade(Punkt p1, Punkt p2) throws SinglePointException {
        if (p1.equals(p2)) throw new SinglePointException(p1);

        int x = p1.getX().compareTo(p2.getX());
        if (x < 0) {
            this.p1 = p1;
            this.p2 = p2;

        } else if (x > 0) {
            this.p1 = p2;
            this.p2 = p1;

        } else {

            int y = p1.getY().compareTo(p2.getY());
            if (y < 0) {
                this.p1 = p1;
                this.p2 = p2;

            } else if (y > 0) {
                this.p1 = p2;
                this.p2 = p1;

            } else {
                // should never go here
                throw new SinglePointException(p1);
            }
        }
    }


    public boolean enthaelt(Punkt p0) {
        return (zwischenp1p2(p0) || vorp1(p0) || hinterp2(p0));
    }

    protected boolean zwischenp1p2(Punkt p0) {
        // p1 <-> p0 + p2 <-> p0 == p1 <-> p2

        BigDecimal p1p2 = p1.abstand(p2);
        BigDecimal p0p1 = p0.abstand(p1);
        BigDecimal p0p2 = p0.abstand(p2);

        return BigDecimalUtility.equalValues(p0p1.add(p0p2), p1p2);
    }

    protected boolean vorp1(Punkt p0) {
        // p0 <-> p1 + p1 <-> p2 == p0 <-> p2

        BigDecimal p1p2 = p1.abstand(p2);
        BigDecimal p0p1 = p0.abstand(p1);
        BigDecimal p0p2 = p0.abstand(p2);

        return BigDecimalUtility.equalValues(p0p1.add(p1p2), p0p2);
    }

    protected boolean hinterp2(Punkt p0) {
        // p0 <-> p2 + p1 <-> p2 = p0 <-> p1

        BigDecimal p1p2 = p1.abstand(p2);
        BigDecimal p0p1 = p0.abstand(p1);
        BigDecimal p0p2 = p0.abstand(p2);

        return BigDecimalUtility.equalValues(p0p2.add(p1p2), p0p1);
    }


    public Punkt getP1() {
        return p1;
    }

    public Punkt getP2() {
        return p2;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj.getClass().equals(Gerade.class)) {
            Gerade g = (Gerade) obj;
            return (this.enthaelt(g.p1) && this.enthaelt(g.p2));
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Gerade durch " + p1 + " und " + p2;
    }

}
