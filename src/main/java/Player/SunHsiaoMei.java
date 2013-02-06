package Player;

import UI.Element;
import UI.Observer;
import org.fusesource.jansi.Ansi;

public class SunHsiaoMei extends Player {
    private Observer observer;

    public SunHsiaoMei(Position initialPosition, Observer observer) {
        super(initialPosition);
        this.observer = observer;
    }

    protected void updateUI(Position source, Position destination) {
        observer.move(source, destination, new Element('S', Ansi.Color.YELLOW));
    }
}
