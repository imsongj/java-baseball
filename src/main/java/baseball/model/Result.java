package baseball.model;

public class Result {
    private int balls;
    private int strikes;

    public Result(int balls, int strikes) {
        this.balls = balls;
        this.strikes = strikes;
    }

    public int getBalls() {
        return balls;
    }

    public int getStrikes() {
        return strikes;
    }
}
