package Player;

import UI.Element;

public abstract class Role {
    private static final Position HOSPITAL = new Position(14);
    private Position currentPosition;
    private int remainTimes = 0;
    private boolean isBlocked = false;

    Role(Position initialPosition) {
        currentPosition = initialPosition;
    }

    public String name() {
        return getClass().toString();
    }

    public void forward(int step) {
        for (int count = 1; count <= step; ++count) {
            updateUI(currentPosition, currentPosition.move(count));
            currentPosition = currentPosition.move(count);
            if (isBlocked) {
                isBlocked = false;
                break;
            }
        }
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

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                currentPosition.equals(((Role) object).currentPosition) &&
                remainTimes == ((Role) object).remainTimes &&
                isBlocked == ((Role) object).isBlocked;
    }

    public abstract String getPromptMessage();

    public abstract Element getElement(char symbol);

    protected abstract void updateUI(Position source, Position destination);
}
