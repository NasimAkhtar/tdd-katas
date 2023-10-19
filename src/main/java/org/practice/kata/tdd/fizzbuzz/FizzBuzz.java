package org.practice.kata.tdd.fizzbuzz;

public class FizzBuzz {
    public String getFizzBuzz(int input) {
        if (input % 15 == 0) return "FizzBuzz";
        if (input % 5 == 0) return "Buzz";
        if (input % 3 == 0) return "Fizz";
        return String.valueOf(input);
    }
}
