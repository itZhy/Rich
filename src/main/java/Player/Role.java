package Player;

public class Role {
    private final String name;
    private final Callback callback;
    private final Movement movement = new Movement();

    public Role(String name, Callback callback) {
        this.name = name;
        this.callback = callback;
    }

    public String name() {
        return name;
    }

    public void forward(int step) {
        for (int count = 1; count <= step; ++count) {
            if (!movement.walk()) {
                break;
            }
            callback.notifyWhileForwarding(name(), movement);
        }
        callback.notifyAfterForwarded(name(), movement);
    }

    public Position currentPosition() {
        return movement.currentPosition();
    }

    public boolean skip() {
        return movement.skip();
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() && movement.equals(((Role) object).movement);
    }
}
