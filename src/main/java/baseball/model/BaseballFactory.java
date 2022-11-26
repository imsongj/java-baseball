package baseball.model;

import java.util.List;

public class BaseballFactory {
    public static Baseball createComputerBaseball() {
        return new Baseball(new RandomNumberGenerator()
                .generateRandomNumbers(BaseballStatistic.SIZE.getValue(),
                BaseballStatistic.LOWER_BOUND.getValue(), BaseballStatistic.UPPER_BOUND.getValue()));
    }

    public static Baseball createPlayerBaseball(List<Integer> numbers) {
        return new Baseball(numbers);
    }
}
