package Player;

import UI.Element;
import UI.UIObserver;
import org.fusesource.jansi.Ansi;

public class BabyKin extends Role {
    private final Ansi.Color color = Ansi.Color.BLUE;

    public BabyKin(Position initialPosition, UIObserver ui, Observer building) {
        super(initialPosition, ui, building);
    }

    public boolean equals(Object object)    {
        return super.equals(object) && ui.equals(((BabyKin)object).ui);
    }

    public String getPromptMessage() {
        return "金贝贝>";
    }

    public Element getElement(char symbol) {
        return new Element(symbol, color);
    }

    protected void updateUI(Position source, Position destination) {
        ui.move(source, destination, new Element('J', color));
    }
}
