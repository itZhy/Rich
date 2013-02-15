package Player;

import UI.Element;
import UI.Observer;
import org.fusesource.jansi.Ansi;

public class BabyKin extends Role {
    private final Observer ui;

    public BabyKin(Position initialPosition, Observer ui) {
        super(initialPosition);
        this.ui = ui;
    }

    public boolean equals(Object object)    {
        return super.equals(object) && ui.equals(((BabyKin)object).ui);
    }

    public String getPromptMessage() {
        return "金贝贝>";
    }

    protected void updateUI(Position source, Position destination) {
        ui.move(source, destination, new Element('J', Ansi.Color.BLUE));
    }
}
