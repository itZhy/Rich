package Estate;

import Player.Position;
import UI.UIObserver;

public class Vacancy extends Building {
    public Vacancy(int price) {
        super(price);
    }

    public Building update(String owner) {
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
