package Player;
import UI.Element;
import UI.UIObserver;

import org.fusesource.jansi.Ansi;

public class SunHsiaoMei extends Player {
    private UIObserver uiObserver;
    private final Element ELEMENT = new Element('S', Ansi.Color.YELLOW);

    public SunHsiaoMei(Position initialPosition, UIObserver initialObserver) {
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
