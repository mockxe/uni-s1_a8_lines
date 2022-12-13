package io.mockxe.uni.s1.a8.lines;

import io.mockxe.uni.s1.a8.lines.external.BigDecimalUtility;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Random;

class PunktTest {

    @Test
    void testAbstandInteger() {
        Punkt a = new Punkt(10, 2);
        Punkt b = new Punkt(5, 14);
        BigDecimal expected = BigDecimal.valueOf(13);

        System.out.println("expected: " + expected);

        BigDecimal ab = a.abstand(b);
        System.out.println("A <--> B: " + ab);
        assert BigDecimalUtility.equalValues(ab, expected);

        BigDecimal ba = b.abstand(a);
        System.out.println("B <--> A: " + ba);
        assert BigDecimalUtility.equalValues(ba, expected);

        assert BigDecimalUtility.equalValues(ab, ba);
    }

    @Test
    void testAbstandDecimal() {
        Punkt a = new Punkt(12, 3);
        Punkt b = new Punkt(5, 9);
        BigDecimal expected = BigDecimal.valueOf(9.22);

        System.out.println("expected: " + expected);

        BigDecimal ab = a.abstand(b);
        System.out.println("A <--> B: " + ab);
        assert BigDecimalUtility.equalValues(ab, expected);

        BigDecimal ba = b.abstand(a);
        System.out.println("B <--> A: " + ba);
        assert BigDecimalUtility.equalValues(ba, expected);

        assert BigDecimalUtility.equalValues(ab, ba);
    }

    @Test
    void testAbstandZero() {
        Punkt a = new Punkt(0, 0);
        Punkt b = new Punkt(0, 0);
        BigDecimal expected = BigDecimal.valueOf(0);

        System.out.println("expected: " + expected);

        BigDecimal ab = a.abstand(b);
        System.out.println("A <--> B: " + ab);
        assert BigDecimalUtility.equalValues(ab, expected);

        BigDecimal ba = b.abstand(a);
        System.out.println("B <--> A: " + ba);
        assert BigDecimalUtility.equalValues(ba, expected);

        assert BigDecimalUtility.equalValues(ab, ba);
    }

    @Test
    void testAbstandRandom() {
        for (int i = 0; i < 100; i++) {
            Random random = new Random();

            BigDecimal c = BigDecimal.valueOf(random.nextInt(1, 100));
            BigDecimal c2 = c.pow(2);
            System.out.println("c: " + c);
            System.out.println("c²: " + c2);

            BigDecimal a2 = BigDecimal.valueOf(random.nextDouble(0, c2.doubleValue()));
            BigDecimal b2 = c2.subtract(a2);
            System.out.println("a²: " + a2);
            System.out.println("b²: " + b2);

            BigDecimal a = BigDecimalUtility.sqrt(a2);
            BigDecimal b = BigDecimalUtility.sqrt(b2);
            System.out.println("a: " + a);
            System.out.println("b: " + b);

            BigDecimal px = BigDecimal.valueOf(random.nextDouble(0, 100));
            BigDecimal py = BigDecimal.valueOf(random.nextDouble(0, 100));
            BigDecimal qx = px.subtract(a);
            BigDecimal qy = py.subtract(b);
            System.out.println("px: " + px);
            System.out.println("py: " + py);
            System.out.println("qx: " + qx);
            System.out.println("qy: " + qy);

            Punkt p = new Punkt(px, py);
            Punkt q = new Punkt(qx, qy);
            BigDecimal expected = c;

            System.out.println("expected: " + expected);

            BigDecimal ab = p.abstand(q);
            System.out.println("A <--> B: " + ab);
            assert BigDecimalUtility.equalValues(ab, expected);

            BigDecimal ba = q.abstand(p);
            System.out.println("B <--> A: " + ba);
            assert BigDecimalUtility.equalValues(ba, expected);

            assert BigDecimalUtility.equalValues(ab, ba);
        }
    }

    @Test
    void testEquals() {

        Punkt a1 = new Punkt(1.5, 3.75);
        Punkt a2 = new Punkt(1.5, 3.75);

        Punkt b1 = new Punkt(1, 3.8);

        assert a1.equals(a1);
        assert a1.equals(a2);
        assert a2.equals(a1);

        assert !a1.equals(b1);
        assert !a2.equals(b1);
        assert !b1.equals(a1);
        assert !b1.equals(a2);

    }
}