package io.mockxe.uni.s1.a8.lines;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StreckeTest {

    @Test
    void testVerlaengern() throws SinglePointException {
        Strecke s1 = new Strecke(
                new Punkt(5, 0),
                new Punkt(10, 0)
        );

        Strahl s2 = s1.verlaengern(true);
        Strahl s3 = s1.verlaengern(false);

        assert s2.startsFromp1();
        assert !s2.startsFromp2();
        assert !s3.startsFromp1();
        assert s3.startsFromp2();
    }

    @Test
    void enthaelt() throws SinglePointException {
        Strecke s1 = new Strecke(
                new Punkt(0, 5),
                new Punkt(0, 10)
        );

        Punkt a = new Punkt(0, 8);
        Punkt b = new Punkt(1, 8);
        Punkt c = new Punkt(0, 4);
        Punkt d = new Punkt(0, 11);

        assert s1.enthaelt(a);
        assert !s1.enthaelt(b);
        assert !s1.enthaelt(c);
        assert !s1.enthaelt(d);
    }

    @Test
    void testEquals() throws SinglePointException {
        Punkt a = new Punkt(5, 0);
        Punkt b = new Punkt(10, 0);

        Strecke s1 = new Strecke(a, b);
        Strecke s2 = new Strecke(a, b);
        Strecke s3 = new Strecke(
                new Punkt(4, 0),
                new Punkt(10, 0)
        );
        Strecke s4 = new Strecke(
                new Punkt(6, 0),
                new Punkt(10, 0)
        );
        Strecke s5 = new Strecke(
                new Punkt(5, 0),
                new Punkt(9, 0)
        );
        Strecke s6 = new Strecke(
                new Punkt(5, 0),
                new Punkt(11, 0)
        );

        assert s1.equals(s2);
        assert s2.equals(s1);
        assert !s1.equals(s3);
        assert !s3.equals(s1);
        assert !s1.equals(s4);
        assert !s4.equals(s1);
        assert !s1.equals(s5);
        assert !s5.equals(s1);
        assert !s1.equals(s6);
        assert !s6.equals(s1);
    }

}