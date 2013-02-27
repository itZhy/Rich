package Player;

import Prop.PropException;

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
        forwardStepByStep(step);
        callback.notifyAfterForwarded(name(), movement);
    }

    public boolean skip() {
        return movement.skip();
    }

    public Position currentPosition() {
        return movement.currentPosition();
    }

    public void leave() {
        movement.leave();
        callback.notifyWhileForwarding(name(), movement);
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() && movement.equals(((Role) object).movement);
    }

    private void forwardStepByStep(int step) {
        try {
            walk(step);
        } catch (PropException e) {
            e.showPromptMessage();
        }
    }

    private void walk(int step) {
        for (int count = 0; count != step; ++count) {
            movement.walk();
            callback.notifyWhileForwarding(name(), movement);
        }
    }
}