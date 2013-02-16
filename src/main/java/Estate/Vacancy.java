package Estate;

import Player.Role;
import UI.Observer;

public class Vacancy {
    private final Observer ui;

    public Vacancy(Observer ui){
        this.ui = ui;
    }

    public Building update(Role owner){
       return (Building)new SoldVacancy(owner, ui);
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                ui.equals(((Vacancy) object).ui);
    }
}
