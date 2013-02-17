package Estate;

import Player.Position;
import Player.Role;
import Player.RoleColor;
import UI.UIObserver;

public class Hovel extends Building {
    public Hovel(String role, UIObserver ui) {
        super(role, ui);
    }

    public Building update(String owner) {
        return null;
    }

    public void updateUI(Position position) {
        ui.replace(position,new RoleColor().dye(owner, '0'), new RoleColor().dye(owner, '1'));
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                owner.equals(((Hovel) object).owner) &&
                ui.equals(((Hovel) object).ui);
    }
}
