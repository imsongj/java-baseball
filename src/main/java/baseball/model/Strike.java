package baseball.model;

public class Strike {
    private static final String MESSAGE = "스트라이크";
    private int strikes;

    public Strike(int strikes) {
        this.strikes = strikes;
    }

    public boolean isZero() {
        return strikes == 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (strikes == 0) {
            return stringBuilder.toString();
        }
        return stringBuilder.append(strikes)
                .append(MESSAGE)
                .toString();
    }

    public boolean isStrikeOut() {
        return strikes == BaseballStatistic.STRIKE_OUT.getValue();
    }
}
