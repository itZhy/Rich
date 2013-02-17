package Estate;

import Player.Position;
import Player.Role;
import UI.UIObserver;

public class SoldVacancy extends Building {


    public SoldVacancy(String role, UIObserver ui){
        super(role, ui);
    }

    public Building update(){
       return null;
    }

    public void updateUI(Position position) {
//        ui.replace(position, owner.getElement('0'));
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                owner.equals(((SoldVacancy) object).owner) &&
                ui.equals(((SoldVacancy) object).ui);
    }
}