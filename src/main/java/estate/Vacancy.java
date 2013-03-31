package estate;

import player.Position;
import player.Role;
import ui.UIObserver;

public class Vacancy extends Building {
    public Vacancy(Money basePrice) {
        super(basePrice);
    }

    public Building update(Role owner) {
        return new SoldVacancy(owner, basePrice);
    }

    public Money toll() {
        return new Money(0.);
    }

    public Money sellingPrice() {
        return new Money(0.);
    }

    public void updateUI(Position position, UIObserver ui) {
    }

    public void clearUI(Position position, UIObserver ui) {
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass();
    }
}
