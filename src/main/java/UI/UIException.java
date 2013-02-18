package UI;

public class UIException extends RuntimeException {
    public static final boolean NEED_NOT_RETRY = false;
    private final String message;
    private boolean isNeedRetry = true;

    public UIException(String message) {
        this.message = message;
    }

    public UIException(String message, boolean isNeedRetry) {
        this.isNeedRetry = isNeedRetry;
        this.message = message;
    }

    public boolean isNeedRetry() {
        return isNeedRetry;
    }

    public String toString() {
        return message;
    }
}
