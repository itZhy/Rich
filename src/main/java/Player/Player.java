package Player;

import UI.Element;
import org.fusesource.jansi.Ansi;

public abstract class Player {
    private Position currentPosition;

    Player(Position initialPosition) {
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

    public abstract String getPromptMessage();
    public abstract Element getElement(char symbol);
    protected abstract void updateUI(Position source, Position destination);

}
