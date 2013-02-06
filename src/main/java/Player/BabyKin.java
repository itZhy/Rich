package Player;

import UI.Element;
import UI.Observer;
import org.fusesource.jansi.Ansi;

public class BabyKin extends Player {
    private Observer observer;

    public BabyKin(Position initialPosition, Observer observer) {
        super(initialPosition);
        this.observer = observer;
    }

    protected void updateUI(Position source, Position destination) {
        observer.move(source, destination, new Element('J', Ansi.Color.BLUE));
    }
}
