package Estate;

import Player.Role;
import UI.Observer;

public class Skyscraper extends Building {

    public Skyscraper(Role role, Observer ui) {
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
