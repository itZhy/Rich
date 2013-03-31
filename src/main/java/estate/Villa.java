package estate;

import player.Position;
import player.Role;
import ui.Element;
import ui.UIObserver;

public class Villa extends Building {
    public Villa(Role owner, Money basePrice) {
        super(basePrice);
        this.owner = owner;
    }

    public Building update(Role owner) {
        return new Skyscraper(this.owner, basePrice);
    }

    public Money toll() {
        return basePrice.multiply(2.);
    }

    public Money sellingPrice() {
        return basePrice.multiply(6.);
    }

    public void updateUI(Position position, UIObserver ui) {
        ui.replace(position, owner.dye(new Element('1')), owner.dye(new Element('2')));
    }

    public void clearUI(Position position, UIObserver ui) {
        ui.replace(position, owner.dye(new Element('2')), new Element('0'));
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                owner.equals(((Villa) object).owner);
    }
}
