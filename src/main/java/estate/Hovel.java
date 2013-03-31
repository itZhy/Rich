package estate;

import player.Position;
import player.Role;
import ui.Element;
import ui.UIObserver;

public class Hovel extends Building {
    public Hovel(Role owner, Money price) {
        super(price);
        this.owner = owner;
    }

    public Building update(Role owner) {
        return new Villa(owner, basePrice);
    }

    public Money toll() {
        return basePrice;
    }

    public Money sellingPrice() {
        return basePrice.multiply(4.);
    }

    public void updateUI(Position position, UIObserver ui) {
        ui.replace(position, owner.dye(new Element('0')), owner.dye(new Element('1')));
    }

    public void clearUI(Position position, UIObserver ui) {
        ui.replace(position, owner.dye(new Element('1')), new Element('0'));
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                owner.equals(((Hovel) object).owner);
    }
}
