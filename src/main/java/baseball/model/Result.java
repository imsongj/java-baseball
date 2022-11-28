package baseball.model;

public class Result {
    private Ball ball;
    private Strike strike;

    public Result(int balls, int strikes) {
        this.ball = new Ball(balls);
        this.strike = new Strike(strikes);
    }

    public boolean isStrikeOut() {
        return strike.isStrikeOut();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ball.toString());
        if (!ball.isZero() && !strike.isZero()) {
            stringBuilder.append(ResultMessage.DELIMITER.getMessage());
        }
        stringBuilder.append(strike.toString());
        if (ball.isZero() && strike.isZero()) {
            return ResultMessage.NOTHING.getMessage();
        }
        return stringBuilder.toString();
    }
}
