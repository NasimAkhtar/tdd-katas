package org.practice.kata.tdd.stringcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {
    public int add(String input) {
        List<Integer> numbers = parseNumbers(input);
        ensureAllNonNegativeNumbers(numbers);
        return sum(numbers);
    }

    private List<Integer> parseNumbers(String input) {
        String[] tokens = tokenize(input);
        return converts(tokens);
    }

    private void ensureAllNonNegativeNumbers(List<Integer> numbers) {
        List<Integer> negativeNumList = checkForNegativeNumbers(numbers);
        if (!negativeNumList.isEmpty())
            throw new IllegalArgumentException("negatives not allowed: " + negativeNumList.toString());
    }

    private List<Integer> checkForNegativeNumbers(List<Integer> numbers) {
        return numbers
                .stream()
                .filter(number -> number < 0)
                .collect(Collectors.toList());
    }

    private int sum(List<Integer> numbers) {
        return numbers
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private List<Integer> converts(String[] tokens) {
        ArrayList<Integer> list = new ArrayList<>();
        for (String token : tokens) {
            list.add(toInt(token));
        }
        return list;
    }

    private String[] tokenize(String input) {
        if (input.isBlank()) return new String[0];
        else if (usesCustomDelimiter(input)) {
            return splitUsingCustomDelimiter(input);
        } else
            return splitUsingCommaOrNewLine(input, ",|\n");
    }

    private boolean usesCustomDelimiter(String input) {
        return input.startsWith("//");
    }

    private String[] splitUsingCommaOrNewLine(String input, String delimiter) {
        return input.split(delimiter);
    }

    private String[] splitUsingCustomDelimiter(String input) {
        Pattern pattern = Pattern.compile("//(.)\n(.*)");
        Matcher matcher = pattern.matcher(input);
        boolean matches = matcher.matches();
        String customDelimiter = matcher.group(1);
        String token = matcher.group(2);

        return token.split(Pattern.quote(customDelimiter));
}

    private int toInt(String token) {
        return Integer.parseInt(token);
    }
}
