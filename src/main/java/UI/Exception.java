package UI;

public class Exception extends RuntimeException {
    private final String message;

    public Exception(String message) {
        this.message = message;
    }

    public String toString() {
        return message;
    }
}
