package io.mockxe.uni.s1.a8.lines;

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


    public Punkt getP1() {
        return p1;
    }

    public Punkt getP2() {
        return p2;
    }


    @Override
    public String toString() {
        return "Gerade durch " + p1 + " und " + p2;
    }

}
