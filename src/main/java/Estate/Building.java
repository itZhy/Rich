package Estate;

import Player.Player;
import UI.Observer;

public abstract class Building {
    protected Player owner;
    protected final Observer ui;

    public Building(Player player, Observer ui){
        owner = player;
        this.ui = ui;
    }

    public abstract Building update();
}
