package Player;

public abstract class Player {
    public Position currentPosition;

    public Player(Position initialPosition) {
        currentPosition = initialPosition;
    }

    public void forward(int step) {
        updateUI(currentPosition, currentPosition.move(step));
        currentPosition = currentPosition.move(step);
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                currentPosition.equals(((Player) object).currentPosition);
    }

    public abstract void showPromptMessage();
    protected abstract void updateUI(Position source, Position destination);
}
