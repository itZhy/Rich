package Estate;

import Player.Role;
import UI.UIObserver;

public class Skyscraper extends Building {

    public Skyscraper(String role, UIObserver ui) {
        super(role, ui);
    }

    public Building update(String owner) {
        return null;
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                owner.equals(((Skyscraper) object).owner) &&
                ui.equals(((Skyscraper) object).ui);
    }
}
