package estate;

import application.GameException;
import player.Role;
import player.Position;
import ui.Element;
import ui.UIObserver;
import org.fusesource.jansi.Ansi;

public class Skyscraper extends Building {

    public Skyscraper(Role owner, Integer basePrice) {
        super(basePrice);
        this.owner = owner;
    }

    public Building update(Role owner) {
        throw new GameException("已经是最高级，不能再升级了。", GameException.NEED_NOT_RETRY);
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
