package baseball.model;

public class Ball {
    private static final String MESSAGE = "볼";
    private int balls;

    public Ball(int balls) {
        this.balls = balls;
    }

    public boolean isZero() {
        return balls == 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (balls == 0) {
            return stringBuilder.toString();
        }
        return stringBuilder.append(balls)
                .append(MESSAGE)
                .toString();
    }
}
