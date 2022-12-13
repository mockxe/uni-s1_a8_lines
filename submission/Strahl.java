sealed class Strahl extends Gerade permits Strecke {

    private final boolean startsFromp1;

    public Strahl(Punkt p1, Punkt p2) throws SinglePointException {
        super(p1, p2);
        startsFromp1 = this.getP1().equals(p1);
    }

    public boolean startsFromp1() {
        return startsFromp1;
    }

    public boolean startsFromp2() {
        return !startsFromp1();
    }

    public Gerade verlaengern() {
        try {
            return new Gerade(getP1(), getP2());
        } catch (SinglePointException e) {
            return null; // swallow exception, should never happen
        }
    }

    @Override
    public boolean enthaelt(Punkt p0) {
        return (zwischenp1p2(p0) || hinterp2(p0));
    }


    @Override
    public boolean equals(Object obj) {
        if (obj.getClass().equals(Strahl.class)) {
            Strahl s = (Strahl) obj;
            return (this.getP1().equals(s.getP1()) && this.enthaelt(s.getP2()));
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        if (startsFromp1) {
            return "Strecke von " + getP1() + " durch " + getP2();
        } else {
            return "Strecke durch " + getP1() + " von " + getP2();
        }

    }
}
