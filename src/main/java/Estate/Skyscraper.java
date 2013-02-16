package Estate;

import Player.Role;
import UI.UIObserver;

public class Skyscraper extends Building {

    public Skyscraper(Role role, UIObserver ui) {
        super(role, ui);
    }

    public Building update() {
        return null;
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                owner.equals(((Skyscraper) object).owner) &&
                ui.equals(((Skyscraper) object).ui);
    }
}
