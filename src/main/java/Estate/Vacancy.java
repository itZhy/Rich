package estate;

import player.Role;
import player.Position;
import ui.UIObserver;

public class Vacancy extends Building {
    public Vacancy(int basePrice) {
        super(basePrice);
    }

    public Building update(Role owner) {
        return new SoldVacancy(owner, basePrice);
    }

    public int toll() {
        return 0;
    }

    public int sellingPrice() {
        return 0;
    }

    public void updateUI(Position position, UIObserver ui) {
    }

    public void clearUI(Position position, UIObserver ui) {
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass();
    }
}
