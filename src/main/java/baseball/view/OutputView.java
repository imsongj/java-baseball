package baseball.view;

public class OutputView {
    public void printGameMessage(GameMessage message) {
        System.out.print(message.getMessage());
    }

    public void printErrorMessage(ErrorMessage message) {
        System.out.print(message.getMessage());
    }
}
