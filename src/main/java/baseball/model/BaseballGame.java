package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private List<Integer> computerNumbers;
    private Referee referee;

    public BaseballGame() {
        referee = new Referee();
    }

    public void resetComputerNumbers() {
        computerNumbers = createComputerNumbers();
    }

    public List<Integer> createComputerNumbers() {
        return new RandomNumberGenerator().generateRandomNumbers(BaseballStatistic.NUMBERS_SIZE.getValue(),
                        BaseballStatistic.LOWER_BOUND.getValue(), BaseballStatistic.UPPER_BOUND.getValue());
    }

    public Result guess(String input) {
        List<Integer> playerNumbers = createPlayerNumbers(input);
        return referee.compare(computerNumbers, playerNumbers);
    }

    public List<Integer> createPlayerNumbers(String input) {
        return input.chars()
                .map(Character::getNumericValue)
                .collect(ArrayList::new, List::add, List::addAll);
    }
}
