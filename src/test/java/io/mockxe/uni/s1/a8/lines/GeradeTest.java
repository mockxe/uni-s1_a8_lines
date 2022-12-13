package io.mockxe.uni.s1.a8.lines;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeradeTest {

    @Test
    void testConstructorX() throws SinglePointException {
        Punkt a = new Punkt(5, 0);
        Punkt b = new Punkt(10, 0);

        Gerade g1 = new Gerade(a, b);
        System.out.println("g1: " + g1);
        assert g1.getP1().equals(a);
        assert g1.getP2().equals(b);

        Gerade g2 = new Gerade(b, a);
        System.out.println("g2: " + g2);
        assert g2.getP1().equals(a);
        assert g2.getP2().equals(b);
    }

    @Test
    void testConstructorY() throws SinglePointException {
        Punkt a = new Punkt(0, 5);
        Punkt b = new Punkt(0, 10);

        Gerade g1 = new Gerade(a, b);
        System.out.println("g1: " + g1);
        assert g1.getP1().equals(a);
        assert g1.getP2().equals(b);

        Gerade g2 = new Gerade(b, a);
        System.out.println("g2: " + g2);
        assert g2.getP1().equals(a);
        assert g2.getP2().equals(b);
    }

    @Test
    void testConstructorException() {
        Punkt a = new Punkt(0, 0);
        Punkt b = new Punkt(0, 0);

        assertThrows(SinglePointException.class, () -> new Gerade(a, b));
    }

    @Test
    void testZwischenp1p2() throws SinglePointException {
        Gerade g1 = new Gerade(
                new Punkt(0, 5),
                new Punkt(0, 10)
        );

        Punkt a = new Punkt(0, 8);
        Punkt b = new Punkt(1, 8);
        Punkt c = new Punkt(0, 4);
        Punkt d = new Punkt(0, 11);

        assert g1.zwischenp1p2(a);
        assert !g1.zwischenp1p2(b);
        assert !g1.zwischenp1p2(c);
        assert !g1.zwischenp1p2(d);
    }

    @Test
    void testVorp1() throws SinglePointException {
        Gerade g1 = new Gerade(
                new Punkt(0, 5),
                new Punkt(0, 10)
        );

        Punkt a = new Punkt(0, 8);
        Punkt b = new Punkt(1, 8);
        Punkt c = new Punkt(0, 4);
        Punkt d = new Punkt(0, 11);

        assert !g1.vorp1(a);
        assert !g1.vorp1(b);
        assert g1.vorp1(c);
        assert !g1.vorp1(d);
    }

    @Test
    void testHinterp2() throws SinglePointException {
        Gerade g1 = new Gerade(
                new Punkt(0, 5),
                new Punkt(0, 10)
        );

        Punkt a = new Punkt(0, 8);
        Punkt b = new Punkt(1, 8);
        Punkt c = new Punkt(0, 4);
        Punkt d = new Punkt(0, 11);

        assert !g1.hinterp2(a);
        assert !g1.hinterp2(b);
        assert !g1.hinterp2(c);
        assert g1.hinterp2(d);
    }

    @Test
    void testEnthealt() throws SinglePointException {
        Gerade g1 = new Gerade(
                new Punkt(0, 5),
                new Punkt(0, 10)
        );

        Punkt a = new Punkt(0, 8);
        Punkt b = new Punkt(1, 8);
        Punkt c = new Punkt(0, 4);
        Punkt d = new Punkt(0, 11);

        assert g1.enthaelt(a);
        assert !g1.enthaelt(b);
        assert g1.enthaelt(c);
        assert g1.enthaelt(d);
    }

}