package io.mockxe.uni.s1.a8.lines;

public class SinglePointException extends Exception {

    private final Punkt punkt;

    public SinglePointException(Punkt punkt) {
        this.punkt = punkt;
    }


    @Override
    public String toString() {
        return "Doppelte Benutzung des Punktes " + punkt.toString();
    }

}
