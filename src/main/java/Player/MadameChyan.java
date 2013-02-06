package Player;

import UI.Element;
import UI.Observer;
import org.fusesource.jansi.Ansi;

public class MadameChyan extends Player {
    private final Element ELEMENT = new Element('Q', Ansi.Color.MAGENTA);
    private Observer observer;

    public MadameChyan(Position initialPosition, Observer observer) {
        super(initialPosition);
        this.observer = observer;
    }

    public void rehabilitatePrevElement() {
        observer.update(currentPosition, recordedElement);
    }

    public void update() {
        recordedElement = observer.get(currentPosition);
        observer.update(currentPosition, ELEMENT);
    }

}
