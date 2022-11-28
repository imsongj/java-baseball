package baseball.view;

public enum ErrorMessage {
    INVALID_INPUT("잘못된 값을 입력했습니다.\n");
    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
