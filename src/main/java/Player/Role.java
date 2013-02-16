package Player;

import UI.Element;

public abstract class Role {
    private static final Position HOSPITAL = new Position(14);
    private Position currentPosition;
    private int remainTimes = 0;

    Role(Position initialPosition) {
        currentPosition = initialPosition;
    }

    public String name() {
        return getClass().toString();
    }

    public void forward(int step) {
        updateUI(currentPosition, currentPosition.move(step));
        currentPosition = currentPosition.move(step);
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

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                currentPosition.equals(((Role) object).currentPosition);
    }

    public abstract String getPromptMessage();

    public abstract Element getElement(char symbol);

    protected abstract void updateUI(Position source, Position destination);

}
