package application;

public class GameException extends RuntimeException {
    private final String message;

    public GameException(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
