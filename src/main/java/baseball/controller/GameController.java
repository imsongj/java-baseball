package baseball.controller;

import baseball.model.BaseballGame;
import baseball.model.Result;
import baseball.model.Validator;
import baseball.view.GameMessage;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    InputView inputView;
    OutputView outputView;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
    }
    public void start() {
        outputView.printGameMessage(GameMessage.START);
        BaseballGame baseballGame = new BaseballGame();
        do {
            run(baseballGame);
        } while (restart(baseballGame));
    }

    public void run(BaseballGame baseballGame) {
        baseballGame.resetComputerNumbers();
        Result result;
        do {
            String input = getPlayerInput();
            Validator.validateNumberInput(input);
            result = baseballGame.guess(input);
            outputView.printResult(result);
        } while(!result.isStrikeOut());
        outputView.printGameMessage(GameMessage.GAME_OVER);
    }

    public boolean restart(BaseballGame baseballGame) {
        outputView.printGameMessage(GameMessage.ASK_RESTART);
        String input = inputView.readPlayerInput();
        Validator.validateRestartInput(input);
        return baseballGame.restart(input);
    }

    public String getPlayerInput() {
        outputView.printGameMessage(GameMessage.ASK_NUMBER);
        return inputView.readPlayerInput();
    }
}
