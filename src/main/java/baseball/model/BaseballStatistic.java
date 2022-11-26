package baseball.model;

public enum BaseballStatistic {
    SIZE(3),
    LOWER_BOUND(1),
    UPPER_BOUND(9);

    private int value;

    BaseballStatistic(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
