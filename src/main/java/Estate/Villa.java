package Estate;

import Player.Feature;
import Player.Position;
import UI.UIObserver;

public class Villa extends Building {
    public Villa(String role, UIObserver ui, Integer price){
        super(role, ui);
        this.price = price;
    }

    public Building update(String owner) {
        return (Building)new Skyscraper(this.owner, ui, price);
    }

    public void updateUI(Position position) {
        ui.replace(position, new Feature().dye(owner, '1'), new Feature().dye(owner, '2'));
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                owner.equals(((Villa) object).owner) &&
                ui.equals(((Villa) object).ui);
    }
}
