package Estate;

import Player.Role;
import UI.Observer;

public abstract class Building {
    protected Role owner;
    protected final Observer ui;

    public Building(Role role, Observer ui){
        owner = role;
        this.ui = ui;
    }

    public abstract Building update();
}
