package Player;

import UI.UIObserver;

public abstract class Role {
    private static final Position HOSPITAL = new Position(14);
    private Movement movement = new Movement();
    private int remainTimes = 0;
    private final Callback callback;
    protected final UIObserver ui;
    private boolean isBlocked = false;


    Role(UIObserver ui, Callback callback) {
        this.ui = ui;
        this.callback = callback;
    }

    public String name() {
        return getClass().toString();
    }

    public void forward(int step) {
        for (int count = 1; count <= step; ++count) {
            updateUI(movement.currentPosition(), movement.currentPosition().move(1));
            movement.walk();
            if (isBlocked) {
                isBlocked = false;
                break;
            }
        }

        callback.notify(name(), movement);
    }

    public void stay(int times) {
        remainTimes = times;
    }

    public boolean skip() {
        if (0 == remainTimes) {
            return false;
        }
        --remainTimes;
        return true;
    }

    public void moveToHospital() {
        updateUI(movement.currentPosition(), HOSPITAL);
        movement.jumpToHospital();
        stay(3);
    }

    public void block() {
        isBlocked = true;
    }

    public Position offset(int step)    {
        return movement.currentPosition().move(step);
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() && movement.equals(((Role) object).movement) &&
                remainTimes == ((Role) object).remainTimes && isBlocked == ((Role) object).isBlocked;
    }

    public abstract String getPromptMessage();

    protected abstract void updateUI(Position source, Position destination);
}
