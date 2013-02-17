package Estate;

import Player.Position;
import UI.UIObserver;
import Player.RoleColor;

public class SoldVacancy extends Building {


    public SoldVacancy(String role, UIObserver ui){
        super(role, ui);
    }

    public Building update(String owner){
       return null;
    }

    public void updateUI(Position position) {
        ui.replace(position, new RoleColor().dye(owner, '0'));
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                owner.equals(((SoldVacancy) object).owner) &&
                ui.equals(((SoldVacancy) object).ui);
    }
}