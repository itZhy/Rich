package Estate;

import Application.GameException;
import Player.Feature;
import Player.Position;
import UI.Element;
import UI.UIObserver;
import org.fusesource.jansi.Ansi;

public class Skyscraper extends Building {

    public Skyscraper(String owner, Integer basePrice) {
        super(basePrice);
        this.owner = owner;
    }

    public Building update(String owner) {
        throw new GameException("已经是最高级，不能再升级了。", GameException.NEED_NOT_RETRY);
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
