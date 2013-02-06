package Player;

import UI.Element;
import org.fusesource.jansi.Ansi;

public class Player {
    public final Position currentPosition;
    public Element recordedElement = new Element('S', Ansi.Color.WHITE);

    public Player(Position initialPosition) {
        currentPosition = initialPosition;
    }

    public void forward(int step) {
        currentPosition.change(step);
    }

    public boolean equals(Object object) {
        return Player.class == object.getClass()&&
                currentPosition.equals(((Player) object).currentPosition);
    }
    public void update() {};
    public void rehabilitatePrevElement(){};
}
