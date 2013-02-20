package Estate;

public class InsolvencyException {
    private final String message;

    public InsolvencyException(String message) {
        this.message = message;
    }

    public String toString() {
        return message;
    }
}
