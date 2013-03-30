package estate;

import org.fusesource.jansi.Ansi;
import player.Position;
import player.Role;
import ui.Element;
import ui.UIObserver;

public class Skyscraper extends Building {

    public Skyscraper(Role owner, Integer basePrice) {
        super(basePrice);
        this.owner = owner;
    }

    public Building update(Role owner) {
        return this;
    }

    public int toll() {
        return basePrice * 4;
    }

    public int sellingPrice() {
        return basePrice * 16;
    }

    public void updateUI(Position position, UIObserver ui) {
        ui.replace(position, owner.dye('2'), owner.dye('3'));
    }

    public void clearUI(Position position, UIObserver ui) {
        ui.replace(position, owner.dye('3'), new Element('0', Ansi.Color.WHITE));
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                owner.equals(((Skyscraper) object).owner);
    }
}
