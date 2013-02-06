package Player;


import UI.Element;
import UI.Observer;
import org.fusesource.jansi.Ansi;

public class BabyKin extends Player {
    private final Element ELEMENT = new Element('J', Ansi.Color.BLUE);
    private Observer observer;

    public BabyKin(Position initialPosition, Observer observer) {
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
