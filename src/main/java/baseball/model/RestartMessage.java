package baseball.model;

public enum RestartMessage {
    RESTART("1"),
    END("2");

    private final String message;

    RestartMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
