package Player;

import UI.Element;
import UI.Observer;
import org.fusesource.jansi.Ansi;

public class MadameChyan extends Role {
    private final Observer ui;

    public MadameChyan(Position initialPosition, Observer ui) {
        super(initialPosition);
        this.ui = ui;
    }

    public boolean equals(Object object)    {
        return super.equals(object) && ui.equals(((MadameChyan)object).ui);
    }

    public String getPromptMessage() {
        return "钱夫人>";
    }

    protected void updateUI(Position source, Position destination) {
        ui.move(source, destination, new Element('Q', Ansi.Color.MAGENTA));
    }

}