package Estate;

import Player.Position;
import Player.Role;
import Player.RoleColor;
import UI.UIObserver;

public class Vacancy extends Building {

    public Vacancy(String role, UIObserver ui){
        super(role, ui);
    }

    public Building update(){
        return null;
    }

    public Building update(String owner){
       return (Building)new SoldVacancy(owner, ui, price);
    }

    public void updateUI(Position position) {
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                ui.equals(((Vacancy) object).ui);
    }
}
