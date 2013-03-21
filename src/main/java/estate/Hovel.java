package estate;

import player.Role;
import player.Position;
import ui.Element;
import ui.UIObserver;
import org.fusesource.jansi.Ansi;

public class Hovel extends Building {
    public Hovel(Role owner, Integer price) {
        super(price);
        this.owner = owner;
    }

    public Building update(Role owner) {
        return new Villa(owner, basePrice);
    }

    public int toll() {
        return basePrice;
    }

    public int sellingPrice() {
        return basePrice * 4;
    }

    public void updateUI(Position position, UIObserver ui) {
        ui.replace(position, owner.dye('0'), owner.dye('1'));
    }

    public void clearUI(Position position, UIObserver ui) {
        ui.replace(position, owner.dye('1'), new Element('0', Ansi.Color.WHITE));
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                owner.equals(((Hovel) object).owner);
    }
}
