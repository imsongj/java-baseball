package baseball.view;

import baseball.model.Result;

public class OutputView {
    public void printGameMessage(GameMessage message) {
        System.out.print(message.getMessage());
    }

    public void printResult(Result result) {
        System.out.print(result.toString());
    }
}
