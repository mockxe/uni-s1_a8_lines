final class Strecke extends Strahl {

    public Strecke(Punkt p1, Punkt p2) throws SinglePointException {
        super(p1, p2);
    }


    public Strahl verlaengern(boolean swap) {
        try {
            if (swap) {
                return new Strahl(getP1(), getP2());
            } else {
                return new Strahl(getP2(), getP1());
            }
        } catch (SinglePointException e) {
            return null; // swallow exception, should never happen
        }
    }

    @Override
    public boolean startsFromp1() {
        return true; // Strecke starts/ends at both points
    }

    @Override
    public boolean startsFromp2() {
        return true; // Strecke starts/ends at both points
    }

    @Override
    public boolean enthaelt(Punkt p0) {
        return zwischenp1p2(p0);
    }


    @Override
    public boolean equals(Object obj) {
        if (obj.getClass().equals(Strecke.class)) {
            Strecke s = (Strecke) obj;
            return (this.getP1().equals(s.getP1()) && this.getP2().equals(s.getP2()));
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Strecke von " + getP1() + " nach " + getP2();
    }

}
