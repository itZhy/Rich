package Player;

import UI.UIObserver;

public abstract class Role {
    private static final Position HOSPITAL = new Position(14);
    private Position currentPosition;
    private int remainTimes = 0;
    private final Callback callback;
    protected final UIObserver ui;
    private boolean isBlocked = false;


    Role(Position initialPosition, UIObserver ui, Callback callback) {
        currentPosition = initialPosition;
        this.ui = ui;
        this.callback = callback;
    }

    public String name() {
        return getClass().toString();
    }

    public void forward(int step) {
        for (int count = 1; count <= step; ++count) {
            updateUI(currentPosition, currentPosition.move(1));
            currentPosition = currentPosition.move(1);
            if (isBlocked) {
                isBlocked = false;
                break;
            }
        }

        callback.notify(currentPosition, name());
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
        updateUI(currentPosition, HOSPITAL);
        currentPosition = HOSPITAL;
        stay(3);
    }

    public void block() {
        isBlocked = true;
    }

    public Position offset(int step)    {
        return currentPosition.move(step);
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() && currentPosition.equals(((Role) object).currentPosition) &&
                remainTimes == ((Role) object).remainTimes && isBlocked == ((Role) object).isBlocked;
    }

    public abstract String getPromptMessage();

    protected abstract void updateUI(Position source, Position destination);
}
