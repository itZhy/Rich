package UI;

public class UIException extends RuntimeException {
    private String message;

    public UIException(String message) {
        this.message = message;
    }

    public String toString() {
        return message;
    }
}
