package Estate;

import Player.Role;
import UI.UIObserver;

public abstract class Building {
    protected Role owner;
    protected final UIObserver ui;

    public Building(Role role, UIObserver ui){
        owner = role;
        this.ui = ui;
    }

    public abstract Building update();
}
