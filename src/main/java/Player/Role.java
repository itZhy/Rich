package Player;

public abstract class Role {
    private final Callback callback;
    private Movement movement = new Movement();

    Role(Callback callback) {
        this.callback = callback;
    }

    public String name() {
        return getClass().toString();
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

    public abstract String getPromptMessage();
}
