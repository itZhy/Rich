package estate;

import player.Position;
import player.Role;
import ui.Element;
import ui.UIObserver;

public class SoldVacancy extends Building {
    public SoldVacancy(Role owner, Money basePrice) {
        super(basePrice);
        this.owner = owner;
    }

    public Building update(Role owner) {
        return new Hovel(this.owner, basePrice);
    }

    public Money toll() {
        return (basePrice.multiply(0.5));
    }

    public Money sellingPrice() {
        return basePrice.multiply(2.);
    }

    public void updateUI(Position position, UIObserver ui) {
        ui.replace(position, new Element('0'), owner.dye(new Element('0')));
    }

    public void clearUI(Position position, UIObserver ui) {
        ui.replace(position, owner.dye(new Element('0')), new Element('0'));
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                owner.equals(((SoldVacancy) object).owner);
    }
}