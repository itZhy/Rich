package Estate;

import Player.Feature;
import Player.Position;
import UI.Element;
import UI.UIObserver;
import org.fusesource.jansi.Ansi;

public class SoldVacancy extends Building {
    public SoldVacancy(String role, UIObserver ui, Integer price) {
        super(role, ui);
        this.price = price;
        degree = 0;
    }

    public Building update(String owner) {
        return new Hovel(this.owner, ui, price);
    }

    public Integer toll() {
        return (price / 2);
    }

    public void updateUI(Position position) {
        ui.replace(position, new Element('0', Ansi.Color.WHITE), new Feature().dye(owner, '0'));
    }

    public void clearUI(Position position) {
        ui.replace(position, new Feature().dye(owner, '0'), new Element('0', Ansi.Color.WHITE));
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                owner.equals(((SoldVacancy) object).owner) &&
                ui.equals(((SoldVacancy) object).ui);
    }
}