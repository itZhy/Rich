package Estate;

import Player.Role;
import UI.UIObserver;

public abstract class Building {
    protected String owner;
    protected final UIObserver ui;

    public Building(String role, UIObserver ui){
        owner = role;
        this.ui = ui;
    }

    public abstract Building update(String owner);
}
