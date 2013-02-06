package Player;
import UI.Element;
import UI.UIObserver;

import org.fusesource.jansi.Ansi;

public class UncleTuu extends Player {
    private UIObserver uiObserver;
    private final Element ELEMENT = new Element('A', Ansi.Color.GREEN);

    public UncleTuu(Position initialPosition, UIObserver initialObserver) {
        super(initialPosition);
        uiObserver = initialObserver;
    }

    public void rehabilitatePrevElement(){
        uiObserver.update(currentPosition, recordedElement);
    }

    public void update() {
        recordedElement = uiObserver.get(currentPosition);
        uiObserver.update(currentPosition, ELEMENT);
    }
}
