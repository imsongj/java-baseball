package baseball.model;

import java.util.List;

public class BaseballGame {
    private Baseball baseball;
    private Referee referee;
    private void resetBaseballs() {
        baseball = BaseballFactory.createComputerBaseball();
    }



}
