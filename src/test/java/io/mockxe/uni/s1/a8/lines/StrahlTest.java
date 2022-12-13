package io.mockxe.uni.s1.a8.lines;

import org.junit.jupiter.api.Test;

class StrahlTest {

    @Test
    void testStartsFrom() throws SinglePointException {
        Punkt a = new Punkt(5, 0);
        Punkt b = new Punkt(10, 0);

        Strahl s1 = new Strahl(a, b);
        System.out.println("s1: " + s1);
        assert s1.getP1().equals(a);
        assert s1.getP2().equals(b);
        assert s1.startsFromp1();
        assert !s1.startsFromp2();

        Strahl s2 = new Strahl(b, a);
        System.out.println("s2: " + s2);
        assert s2.getP1().equals(a);
        assert s2.getP2().equals(b);
        assert !s2.startsFromp1();
        assert s2.startsFromp2();
    }

    @Test
    void testEnthealt() throws SinglePointException {
        Strahl s = new Strahl(
                new Punkt(0, 5),
                new Punkt(0, 10)
        );

        Punkt a = new Punkt(0, 8);
        Punkt b = new Punkt(1, 8);
        Punkt c = new Punkt(0, 4);
        Punkt d = new Punkt(0, 11);

        assert s.enthaelt(a);
        assert !s.enthaelt(b);
        assert !s.enthaelt(c);
        assert s.enthaelt(d);
    }

    @Test
    void testEqualsPointsEqual() throws SinglePointException {
        Punkt a = new Punkt(5, 0);
        Punkt b = new Punkt(10, 0);

        Strahl s1 = new Strahl(a, b);
        Strahl s2 = new Strahl(a, b);

        assert s1.equals(s2);
        assert s2.equals(s1);
    }

    @Test
    void testEqualsEndsBefore() throws SinglePointException {
        Strahl s1 = new Strahl(
                new Punkt(5, 0),
                new Punkt(10, 0)
        );
        Strahl s2 = new Strahl(
                new Punkt(5, 0),
                new Punkt(9, 0)
        );

        assert s1.equals(s2);
        assert s2.equals(s1);
    }

    @Test
    void testEqualsEndsBehind() throws SinglePointException {
        Strahl s1 = new Strahl(
                new Punkt(5, 0),
                new Punkt(10, 0)
        );
        Strahl s2 = new Strahl(
                new Punkt(5, 0),
                new Punkt(11, 0)
        );

        assert s1.equals(s2);
        assert s2.equals(s1);
    }

    @Test
    void testEqualsStartsBefore() throws SinglePointException {
        Strahl s1 = new Strahl(
                new Punkt(5, 0),
                new Punkt(10, 0)
        );
        Strahl s2 = new Strahl(
                new Punkt(4, 0),
                new Punkt(10, 0)
        );

        assert !s1.equals(s2);
        assert !s2.equals(s1);
    }

    @Test
    void testEqualsStartsBehind() throws SinglePointException {
        Strahl s1 = new Strahl(
                new Punkt(5, 0),
                new Punkt(10, 0)
        );
        Strahl s2 = new Strahl(
                new Punkt(6, 0),
                new Punkt(10, 0)
        );

        assert !s1.equals(s2);
        assert !s2.equals(s1);
    }

}