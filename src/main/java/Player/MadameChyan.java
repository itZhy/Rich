package Player;

import Estate.BuildingObserver;
import UI.Element;
import UI.Observer;
import org.fusesource.jansi.Ansi;

public class MadameChyan extends Role {
    private final Observer ui;
    private final BuildingObserver building;
    private final Ansi.Color color = Ansi.Color.MAGENTA;

    public MadameChyan(Position initialPosition, Observer ui, BuildingObserver building) {
        super(initialPosition);
        this.ui = ui;
        this.building = building;
    }

    public boolean equals(Object object)    {
        return super.equals(object) && ui.equals(((MadameChyan)object).ui);
    }

    public String getPromptMessage() {
        return "钱夫人>";
    }


    public Element getElement(char symbol) {
        return new Element(symbol, color);
    }

    protected void updateUI(Position source, Position destination) {
        ui.move(source, destination, new Element('Q', color));
    }

    protected void handleEstate(){
        building.handle(this);
    }

}