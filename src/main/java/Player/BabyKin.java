package Player;


import UI.Element;
import UI.UIObserver;

import org.fusesource.jansi.Ansi;

public class BabyKin extends Player {
    private UIObserver uiObserver;
    private final Element ELEMENT = new Element('J', Ansi.Color.BLUE);

    public BabyKin(Position initialPosition, UIObserver initialObserver) {
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
