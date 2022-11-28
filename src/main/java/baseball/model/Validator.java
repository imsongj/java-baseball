package baseball.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Validator {
    private static final String NUMERIC_PATTERN = "^[0-9]*$";
    public static void validateNumberInput(String input) {
        validateNumeric(input);
        validateSize(input);
        List<Integer> numbers = input.chars()
                .map(Character::getNumericValue)
                .collect(ArrayList::new, List::add, List::addAll);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    public static void validateRestartInput(String input) {
        if (!input.equals(RestartMessage.RESTART.getMessage()) && !input.equals(RestartMessage.END.getMessage())) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateNumeric(String input) {
        if (input == null || input.isEmpty() || !Pattern.matches(NUMERIC_PATTERN, input)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateSize(String input) {
        if (input.length() != BaseballStatistic.NUMBERS_SIZE.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < BaseballStatistic.LOWER_BOUND.getValue()
                    || number > BaseballStatistic.UPPER_BOUND.getValue()) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> numbersWithoutDuplicates = new HashSet<>(numbers);
        if (numbersWithoutDuplicates.size() != BaseballStatistic.NUMBERS_SIZE.getValue()) {
            throw new IllegalArgumentException();
        }
    }
}
