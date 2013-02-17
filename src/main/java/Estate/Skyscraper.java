package Estate;

import Player.Position;
import Player.Role;
import Player.RoleColor;
import UI.UIObserver;

public class Skyscraper extends Building {

    public Skyscraper(String role, UIObserver ui) {
        super(role, ui);
    }

    public Building update(String owner) {
        return null;
    }

    public void updateUI(Position position) {
        ui.replace(position,new RoleColor().dye(owner, '2'), new RoleColor().dye(owner, '3'));
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                owner.equals(((Skyscraper) object).owner) &&
                ui.equals(((Skyscraper) object).ui);
    }
}
