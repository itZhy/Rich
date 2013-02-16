package Estate;

import Player.Role;
import UI.Observer;

public class Hovel extends Building {
    public Hovel(Role role, Observer ui) {
        super(role, ui);
    }

    public Building update() {
        return null;
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                owner.equals(((Hovel) object).owner) &&
                ui.equals(((Hovel) object).ui);
    }
}
