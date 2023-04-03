package org.example.model;

import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class PolynomialTest {


    @Test
    public void testAdd() {
        String polinom1 = "-3x^2-2x^1+1x^0";
        String polinom2 = "5x^3+2x^1+1x^0";
        assertEquals("{0=2.0, 1=0.0, 2=-3.0, 3=5.0}", Polynomial.addPolynomials(polinom1,polinom2).toString());
    }
    @Test
    public void testSub() {
        String polinom1 = "-3x^2-2x^1+1x^0";
        String polinom2 = "5x^3+2x^1+1x^0";
        assertEquals("{0=1.0, 1=-4.0, 2=-3.0, 3=-5.0}", Polynomial.substract(polinom1,polinom2).toString());
    }
    @Test
    public void testMultiply() {
        String polinom1 = "-3x^2-2x^1+1x^0";
        String polinom2 = "5x^3+2x^1+1x^0";
        assertEquals("{0=1.0, 1=0.0, 2=-7.0, 3=-1.0, 4=-10.0, 5=-15.0}", Polynomial.multiply(polinom1,polinom2).toString());
    }
    @Test
    public void testDerivate() {
        String polinom1 = "-3x^2-2x^1+1x^0";
        assertEquals("{0=-2.0, 1=-6.0}", Polynomial.derivative(polinom1).toString());
    }
    @Test
    public void testIntegrate() {
        String polinom1 = "-3x^2-2x^1+1x^0";

        assertEquals("{0=0.0, 1=1.0, 2=-1.0, 3=-1.0}", Polynomial.integrate(polinom1).toString());
    }
}

