package Player;

import UI.Element;

public abstract class Role {
    private Position currentPosition;

    Role(Position initialPosition) {
        currentPosition = initialPosition;
    }

    public String name()    {
        return getClass().toString();
    }

    public void forward(int step) {
        updateUI(currentPosition, currentPosition.move(step));
        currentPosition = currentPosition.move(step);
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                currentPosition.equals(((Role) object).currentPosition);
    }

    public abstract String getPromptMessage();
    public abstract Element getElement(char symbol);
    protected abstract void updateUI(Position source, Position destination);

}
