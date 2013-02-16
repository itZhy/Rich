package Estate;

import Player.Position;
import Player.Player;
import UI.Element;
import UI.Observer;
import org.fusesource.jansi.Ansi;

public class Vacancy {
    private final Observer ui;

    public Vacancy(Observer ui){
        this.ui = ui;
    }

    public Building update(Player owner){
       return (Building)new SoldVacancy(owner, ui);
    }


}
