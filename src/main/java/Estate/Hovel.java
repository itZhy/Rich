package Estate;

import Player.Feature;
import Player.Position;
import UI.UIObserver;

public class Hovel extends Building {
    public Hovel(String role, UIObserver ui, Integer price){
        super(role, ui);
        this.price = price;
    }

    public Building update(String owner) {
        return null;
    }

    public void updateUI(Position position) {
        ui.replace(position,new Feature().dye(owner, '0'), new Feature().dye(owner, '1'));
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                owner.equals(((Hovel) object).owner) &&
                ui.equals(((Hovel) object).ui);
    }
}
