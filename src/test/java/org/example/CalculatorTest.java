package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void add() {
        assertEquals(5, Calculator.add(2, 3));
    }

    @Test
    public void sub() {
        assertEquals(1, Calculator.sub(3, 2));
    }

    @Test
    public void mul() {
        assertEquals(6.0, Calculator.mul(2, 3), 0.0001);
    }

    @Test
    public void testDivide() {
        assertEquals(2.0, Calculator.div(6, 3), 0.0001);
    }

    @Test
    public void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> Calculator.div(5, 0));
    }

    @Test
    public void testPower() {
        assertEquals(8.0, Calculator.power(2, 3), 0.0001);
    }

    @Test
    public void testSqrt() {
        assertEquals(3.0, Calculator.sqrt(9), 0.0001);
    }

    @Test
    public void testLog() {
        assertEquals(Math.log(10), Calculator.log(10), 0.0001);
    }

    @Test
    public void testFactorial() {
        assertEquals(120, Calculator.factorial(5));
    }
}