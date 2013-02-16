package Estate;

import Player.Role;
import UI.Observer;

public class Vacancy extends Building {

    public Vacancy(Role role, Observer ui){
        super(role, ui);
    }

    public Building update(){
        return null;
    }

    public Building update(Role owner){
       return (Building)new SoldVacancy(owner, ui);
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                ui.equals(((Vacancy) object).ui);
    }
}
