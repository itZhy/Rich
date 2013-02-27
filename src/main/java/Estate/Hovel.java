package Estate;

import Player.Feature;
import Player.Position;
import UI.Element;
import UI.UIObserver;
import org.fusesource.jansi.Ansi;

public class Hovel extends Building {
    public Hovel(String owner, Integer price) {
        super(owner, price);
    }

    public Building update(String owner) {
        return new Villa(owner, basePrice);
    }

    public int toll() {
        return basePrice;
    }

    public int sellingPrice() {
        return basePrice * 4;
    }

    public void updateUI(Position position, UIObserver ui) {
        ui.replace(position, new Feature().dye(owner, '0'), new Feature().dye(owner, '1'));
    }

    public void clearUI(Position position, UIObserver ui) {
        ui.replace(position, new Feature().dye(owner, '1'), new Element('0', Ansi.Color.WHITE));
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                owner.equals(((Hovel) object).owner);
    }
}
