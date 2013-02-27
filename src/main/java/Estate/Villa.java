package Estate;

import Player.Feature;
import Player.Position;
import UI.Element;
import UI.UIObserver;
import org.fusesource.jansi.Ansi;

public class Villa extends Building {
    public Villa(String owner, Integer price) {
        super(owner, price);
    }

    public Building update(String owner) {
        return new Skyscraper(this.owner, basePrice);
    }

    public int toll() {
        return basePrice * 2;
    }

    public int sellingPrice() {
        return basePrice * 8;
    }

    public void updateUI(Position position, UIObserver ui) {
        ui.replace(position, new Feature().dye(owner, '1'), new Feature().dye(owner, '2'));
    }

    public void clearUI(Position position, UIObserver ui) {
        ui.replace(position, new Feature().dye(owner, '2'), new Element('0', Ansi.Color.WHITE));
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                owner.equals(((Villa) object).owner);
    }
}
