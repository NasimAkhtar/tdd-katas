package org.practice.kata.tdd.fizzbuzz;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {

    public static FizzBuzz fizzBuzz;

    @BeforeAll
    public static void setup() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void whenInputIsMultipleOf3ShouldReturnFizz() {
        assertEquals("Fizz", fizzBuzz.getFizzBuzz(3));
        assertEquals("Fizz", fizzBuzz.getFizzBuzz(18));
    }

    @Test
    public void whenInputIsMultipleOf5ShouldReturnBuzz() {
        assertEquals("Buzz", fizzBuzz.getFizzBuzz(5));
        assertEquals("Buzz", fizzBuzz.getFizzBuzz(10));
    }

    @Test
    public void whenInputIsMultipleOf3And5ShouldReturnFizzBuzz() {
        assertEquals("FizzBuzz", fizzBuzz.getFizzBuzz(15));
        assertEquals("FizzBuzz", fizzBuzz.getFizzBuzz(30));
        assertEquals("FizzBuzz", fizzBuzz.getFizzBuzz(45));
    }

    @Test
    public void whenInputIsNotMultipleOf3Or5OrMultipleOf3And5ShouldReturnInputAsText() {
        assertEquals("2", fizzBuzz.getFizzBuzz(2));
        assertEquals("7", fizzBuzz.getFizzBuzz(7));
        assertEquals("11", fizzBuzz.getFizzBuzz(11));
    }

}
