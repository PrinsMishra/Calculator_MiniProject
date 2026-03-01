package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    void testAdd() {
        assertEquals(5, Calculator.add(2, 3));
    }

    @Test
    void testSub() {
        assertEquals(1, Calculator.sub(3, 2));
    }

    @Test
    void testMul() {
        assertEquals(6, Calculator.mul(2, 3));
    }

    @Test
    void testDiv() {
        assertEquals(2, Calculator.div(4, 2));
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> {
            Calculator.div(5, 0);
        });
    }


    @Test
    void testNegativeNumbers() {
        assertEquals(-1, Calculator.add(-3, 2));
    }


    @Test
    void testDecimalDivision() {
        assertEquals(2.5, Calculator.div(5, 2));
    }
}