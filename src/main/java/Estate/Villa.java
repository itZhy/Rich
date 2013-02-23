package Estate;

import Player.Feature;
import Player.Position;
import UI.Element;
import UI.UIObserver;
import org.fusesource.jansi.Ansi;

public class Villa extends Building {
    public Villa(String role, UIObserver ui, Integer price) {
        super(role, ui);
        this.price = price;
        degree = 2;
    }

    public Building update(String owner) {
        return (Building) new Skyscraper(this.owner, ui, price);
    }

    public Integer toll() {
        return price * 2;
    }

    public void updateUI(Position position) {
        ui.replace(position, new Feature().dye(owner, '1'), new Feature().dye(owner, '2'));
    }

    public void clear(Position position) {
        ui.replace(position, new Feature().dye(owner, '2'), new Element('0', Ansi.Color.WHITE));
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                owner.equals(((Villa) object).owner) &&
                ui.equals(((Villa) object).ui);
    }
}
