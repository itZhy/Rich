package Estate;

import Player.Position;
import Player.Role;
import UI.Element;
import UI.Observer;
import org.fusesource.jansi.Ansi;

public class SoldVacancy extends Building {


    public SoldVacancy(Role role, Observer ui){
        super(role, ui);
    }

    public Building update(){
       return null;
    }

    public void updateUI(Position position) {
        ui.replace(position, owner.getElement('0'));
    }
}