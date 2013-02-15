package UI;

public class UIException extends RuntimeException {
    public static final boolean NEED_QUIT = true;
    private final String message;
    private boolean isNeedQuit = false;

    public UIException(String message) {
        this.message = message;
    }

    public UIException(String message, boolean isNeedQuit) {
        this.isNeedQuit = isNeedQuit;
        this.message = message;
    }

    public boolean isNeedQuit() {
        return isNeedQuit;
    }

    public String toString() {
        return message;
    }
}
