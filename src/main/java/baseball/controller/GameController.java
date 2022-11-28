package baseball.controller;

import baseball.model.BaseballGame;
import baseball.model.Result;
import baseball.model.Validator;
import baseball.view.ErrorMessage;
import baseball.view.GameMessage;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    InputView inputView;
    OutputView outputView;
    boolean isValidInput;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
    }
    /*public void start() {
        outputView.printGameMessage(GameMessage.START);
        BaseballGame baseballGame = new BaseballGame();
        do {
            run(baseballGame);
        } while (isValidInput && );

    }*/

    public void run(BaseballGame baseballGame) {
        baseballGame.resetComputerNumbers();
        Result result;
        do {
            String input = inputView.readPlayerInput();
            if (!(isValidInput = validateNumberInput(input))) {
                break;
            }
            result = baseballGame.guess(input);
        } while(!result.isStrikeOut());
    }

    public boolean validateNumberInput(String input) {
        try {
            Validator.validateNumberInput(input);
            return true;
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            return false;
        }
    }
}
