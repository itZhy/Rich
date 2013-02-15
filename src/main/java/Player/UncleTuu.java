package Player;

import UI.Element;
import UI.Observer;
import org.fusesource.jansi.Ansi;

public class UncleTuu extends Player {
    private final Observer ui;

    public UncleTuu(Position initialPosition, Observer ui) {
        super(initialPosition);
        this.ui = ui;
    }

    public boolean equals(Object object)    {
        return super.equals(object) && ui.equals(((UncleTuu)object).ui);
    }

    public String getPromptMessage() {
        return "阿土伯>";
    }

    protected void updateUI(Position source, Position destination) {
        ui.move(source, destination, new Element('A', Ansi.Color.GREEN));
    }
}
