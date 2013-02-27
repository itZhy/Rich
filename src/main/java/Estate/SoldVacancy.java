package Estate;

import Player.Feature;
import Player.Position;
import UI.Element;
import UI.UIObserver;
import org.fusesource.jansi.Ansi;

public class SoldVacancy extends Building {
    public SoldVacancy(String owner, Integer basePrice) {
        super(basePrice);
        this.owner = owner;
    }

    public Building update(String owner) {
        return new Hovel(this.owner, basePrice);
    }

    public int toll() {
        return (basePrice / 2);
    }

    public int sellingPrice() {
        return basePrice * 2;
    }

    public void updateUI(Position position, UIObserver ui) {
        ui.replace(position, new Element('0', Ansi.Color.WHITE), new Feature().dye(owner, '0'));
    }

    public void clearUI(Position position, UIObserver ui) {
        ui.replace(position, new Feature().dye(owner, '0'), new Element('0', Ansi.Color.WHITE));
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                owner.equals(((SoldVacancy) object).owner);
    }
}