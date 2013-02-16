package Player;

import Estate.BuildingObserver;
import UI.Element;
import UI.Observer;
import org.fusesource.jansi.Ansi;

public class UncleTuu extends Role {
    private final Observer ui;
    private final BuildingObserver building;
    private final Ansi.Color color = Ansi.Color.YELLOW;

    public UncleTuu(Position initialPosition, Observer ui, BuildingObserver building) {
        super(initialPosition);
        this.building = building;
        this.ui = ui;
    }

    public boolean equals(Object object) {
        return super.equals(object) && ui.equals(((UncleTuu) object).ui);
    }

    public String getPromptMessage() {
        return "阿土伯>";
    }

    public Element getElement(char symbol) {
        return new Element(symbol, color);
    }

    protected void updateUI(Position source, Position destination) {
        ui.move(source, destination, new Element('A', color));
    }

    protected void handleEstate(){
        building.handle(this);
    }
}
