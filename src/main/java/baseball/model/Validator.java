package baseball.model;

import java.util.regex.Pattern;

public class Validator {
    private static final String NUMERIC_PATTERN = "^[0-9]*$";
    public static void validateNumberInput(String input) {
        validateNumeric(input);
        validateSize(input);
        validateRange(input);
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

    public static void validateRange(String input) {
        int number = Integer.parseInt(input);
        for (int index = 0; index < BaseballStatistic.NUMBERS_SIZE.getValue(); index++) {
            if (number % 10 < BaseballStatistic.LOWER_BOUND.getValue()
                    || number % 10 > BaseballStatistic.UPPER_BOUND.getValue()) {
                throw new IllegalArgumentException();
            }
            number /= 10;
        }
    }
}
