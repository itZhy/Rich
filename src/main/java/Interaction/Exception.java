package Interaction;

public class Exception extends RuntimeException{
    private String message;

    public Exception(String message) {
        this.message = message;
    }

    public String toString() {
        return message;
    }
}
