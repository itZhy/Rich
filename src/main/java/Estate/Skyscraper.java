package Estate;

import Player.Feature;
import Player.Position;
import UI.Element;
import UI.UIObserver;
import org.fusesource.jansi.Ansi;

public class Skyscraper extends Building {

    public Skyscraper(String owner, Integer price) {
        super(price);
        this.owner = owner;
    }

    public Building update(String owner) {
        return null;
    }

    public int toll() {
        return basePrice * 4;
    }

    public int sellingPrice() {
        return basePrice * 16;
    }

    public void updateUI(Position position, UIObserver ui) {
        ui.replace(position, new Feature().dye(owner, '2'), new Feature().dye(owner, '3'));
    }

    public void clearUI(Position position, UIObserver ui) {
        ui.replace(position, new Feature().dye(owner, '3'), new Element('0', Ansi.Color.WHITE));
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                owner.equals(((Skyscraper) object).owner);
    }
}
