package player;

import prop.PropException;

public class Player {
    private final Role role;
    private final Callback callback;
    private final Movement movement = new Movement();

    public Player(Role role, Callback callback) {
        this.role = role;
        this.callback = callback;
    }

    public Role role() {
        return role;
    }

    public void forward(int step) {
        forwardStepByStep(step);
        callback.notifyAfterForwarded(role, movement);
    }

    public void skip() {
        movement.pass();
    }

    public boolean isNeedNotSkip() {
        return movement.isNeedNotSkip();
    }

    public Position offsetPosition(int step) {
        return movement.offset(step);
    }

    public void leave() {
        movement.leave();
        callback.notifyWhileForwarding(role, movement);
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() && movement.equals(((Player) object).movement);
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
            callback.notifyWhileForwarding(role, movement);
        }
    }
}