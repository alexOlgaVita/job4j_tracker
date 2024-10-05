package ru.job4j.oop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

class PointTest {

    @Test
    void whenPoints00And20Then2() {
        Point a = new Point(0, 0);
        Point b = new Point(2, 0);
        double expected = 2.0;
        double output = a.distance(b);
        assertThat(output).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void whenPointsMinus1Minus1And1And1Then2Dot83() {
        Point a = new Point(-1, -1);
        Point b = new Point(1, 1);
        double expected = 2.83;
        double output = a.distance(b);
        assertThat(output).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void whenPointsMinus2Minus2And2And2Then5Dot66() {
        Point a = new Point(-2, -2);
        Point b = new Point(2, 2);
        double expected = 5.66;
        double output = a.distance(b);
        assertThat(output).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void whenPointsMinus77Minus2AndMinus23And0Then54Dot04() {
        Point a = new Point(-77, -2);
        Point b = new Point(-23, 0);
        double expected = 54.04;
        double output = a.distance(b);
        assertThat(output).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void whenPoints99AndMinus9AndMinus9Then25Dot46() {
        Point a = new Point(9, 9);
        Point b = new Point(-9, -9);
        double expected = 25.46;
        double output = a.distance(b);
        assertThat(output).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void whenPointsMinus7And6And9AndMinus7Then20Dot62() {
        Point a = new Point(-7, 6);
        Point b = new Point(9, -7);
        double expected = 20.62;
        double output = a.distance(b);
        assertThat(output).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void whenPoints000And200Then2() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(2, 0, 0);
        double expected = 2.0;
        double output = a.distance3d(b);
        assertThat(output).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void whenPointsMinus1Minus1Minus1And1And1And1Then3Dot46() {
        Point a = new Point(-1, -1, -1);
        Point b = new Point(1, 1, 1);
        double expected = 3.46;
        double output = a.distance3d(b);
        assertThat(output).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void whenPointsMinus2Minus2Minus2And2And2And2Then6Dot93() {
        Point a = new Point(-2, -2, -2);
        Point b = new Point(2, 2, 2);
        double expected = 6.93;
        double output = a.distance3d(b);
        assertThat(output).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void whenPointsMinus77Minus2Minus1AndMinus23And0And1Then54Dot07() {
        Point a = new Point(-77, -2, -1);
        Point b = new Point(-23, 0, 1);
        double expected = 54.07;
        double output = a.distance3d(b);
        assertThat(output).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void whenPoints999AndMinus9Minus9Minus9Then31Dot18() {
        Point a = new Point(9, 9, 9);
        Point b = new Point(-9, -9, -9);
        double expected = 31.18;
        double output = a.distance3d(b);
        assertThat(output).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void whenPointsMinus7And6Minus6And9AndMinus7MinusThreeThen20Dot83() {
        Point a = new Point(-7, 6, -6);
        Point b = new Point(9, -7, -3);
        double expected = 20.83;
        double output = a.distance3d(b);
        assertThat(output).isEqualTo(expected, withPrecision(0.01));
    }
}