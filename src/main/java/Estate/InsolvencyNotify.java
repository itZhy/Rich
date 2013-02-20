package Estate;

public class InsolvencyNotify extends RuntimeException {
    private final String role;

    public InsolvencyNotify(String role) {
        this.role = role;
    }

    public String toString() {
        return role;
    }
}
