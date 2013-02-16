package Player;

import UI.Element;
import UI.Observer;
import org.fusesource.jansi.Ansi;

public class SunHsiaoMei extends Role {
    private final Observer ui;
    private final Ansi.Color color = Ansi.Color.YELLOW;

    public SunHsiaoMei(Position initialPosition, Observer ui) {
        super(initialPosition);
        this.ui = ui;
    }

    public boolean equals(Object object)    {
        return super.equals(object) && ui.equals(((SunHsiaoMei)object).ui);
    }

    public String getPromptMessage() {
        return "孙美美>";
    }

    public Element getElement(char symbol) {
        return new Element(symbol, color);
    }

    protected void updateUI(Position source, Position destination) {
        ui.move(source, destination, new Element('S',color));
    }
}
