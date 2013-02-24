package Estate;

import Player.Position;
import UI.UIObserver;

public class Vacancy extends Building {

    public Vacancy(String role, UIObserver ui) {
        super(role, ui);

    }

    public Building update() {
        return null;
    }

    public Integer toll() {
        return 0;
    }

    public Building update(String owner) {
        return new SoldVacancy(owner, ui, price);
    }

    public void updateUI(Position position) {
    }

    public void clear(Position position) {
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                ui.equals(((Vacancy) object).ui);
    }
}
