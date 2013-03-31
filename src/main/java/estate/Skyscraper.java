package estate;

import player.Position;
import player.Role;
import ui.Element;
import ui.UIObserver;

public class Skyscraper extends Building {

    public Skyscraper(Role owner, Money basePrice) {
        super(basePrice);
        this.owner = owner;
    }

    public Building update(Role owner) {
        return this;
    }

    public Money toll() {
        return basePrice.multiply(4.);
    }

    public Money sellingPrice() {
        return basePrice.multiply(16.);
    }

    public void updateUI(Position position, UIObserver ui) {
        ui.replace(position, owner.dye(new Element('2')), owner.dye(new Element('3')));
    }

    public void clearUI(Position position, UIObserver ui) {
        ui.replace(position, owner.dye(new Element('3')), new Element('0'));
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                owner.equals(((Skyscraper) object).owner);
    }
}
