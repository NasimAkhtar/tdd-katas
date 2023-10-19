package org.practice.kata.tdd.stringcalculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class StringCalculatorTest {

    public static StringCalculator stringCalculator;

    @BeforeAll
    public static void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void testAdd_whenInputIsEmptyStringReturns0() {
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void testAdd_whenInputIsANumberReturnsNumber() {
        assertEquals(1, stringCalculator.add("1"));
    }

    @Test
    public void testAdd_whenInputIsCommaSeparatedIntsReturnsSum() {
        assertEquals(100, stringCalculator.add("1,99"));
    }

    @Test
    public void testAdd_whenInputIsCommaSeparatedMultipleIntsReturnsSum() {
        assertEquals(6, stringCalculator.add("1,2,3"));
    }

    @Test
    public void testAdd_shouldAcceptNewLineAsValidDelimiterReturnsSum() {
        assertEquals(6, stringCalculator.add("1\n2,3"));
    }

    @Test
    public void testAdd_shouldAcceptCustomDelimiterReturnsSum() {
        assertEquals(3, stringCalculator.add("//;\n1;2"));
    }

    @Test
    public void testAdd_shouldAcceptRegexSpecialCharAsCustomDelimiterReturnsSum() {
        assertEquals(3, stringCalculator.add("//.\n1.2"));
    }

    @Test
    public void testAdd_throwsExceptionOnNegativeNumber() {
        try {
            stringCalculator.add("1,-2,3");
            fail("Exception expected.");
        } catch (RuntimeException ex) {
        }
    }

    @Test
    public void testAdd_throwsExceptionOnNegativeNumberWithMessageIncludingNegatives() {
        try {
            stringCalculator.add("1,-2,-3");
            fail("Exception expected.");
        } catch (RuntimeException ex) {
            assertEquals("negatives not allowed: [-2, -3]", ex.getMessage());
        }
    }
}
