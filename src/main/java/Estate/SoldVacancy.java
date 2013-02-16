package Estate;

import Player.Position;
import Player.Player;
import UI.Element;
import UI.Observer;
import org.fusesource.jansi.Ansi;

public class SoldVacancy extends Building {


    public SoldVacancy(Player player, Observer ui){
        super(player, ui);
    }

    public Building update(){
       return null;
    }

    public void updateUI(Position position) {
        ui.replace(position, owner.getElement('0'));
    }
}