package Estate;

import Player.Role;
import UI.UIObserver;

public class Hovel extends Building {
    public Hovel(String role, UIObserver ui) {
        super(role, ui);
    }

    public Building update(String owner) {
        return null;
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                owner.equals(((Hovel) object).owner) &&
                ui.equals(((Hovel) object).ui);
    }
}
