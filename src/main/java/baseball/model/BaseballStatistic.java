package baseball.model;

public enum BaseballStatistic {
    NUMBERS_SIZE(3),
    LOWER_BOUND(1),
    UPPER_BOUND(9),
    STRIKE_OUT(3);

    private int value;

    BaseballStatistic(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
