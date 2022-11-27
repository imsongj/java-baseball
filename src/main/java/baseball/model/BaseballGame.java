package baseball.model;

import java.util.List;

public class BaseballGame {
    private List<Integer> computerNumbers;
    private Referee referee;

    public BaseballGame() {
        referee = new Referee();
    }

    private void resetComputerNumbers() {
        computerNumbers = createComputerBaseball();
    }

    public List<Integer> createComputerBaseball() {
        return new RandomNumberGenerator().generateRandomNumbers(BaseballStatistic.SIZE.getValue(),
                        BaseballStatistic.LOWER_BOUND.getValue(), BaseballStatistic.UPPER_BOUND.getValue());
    }

}
