package Estate;

import Player.Position;
import UI.UIObserver;

public abstract class Building {
    protected String owner;
    protected final UIObserver ui;
    protected Integer price;

    public Building(String role, UIObserver ui){
        owner = role;
        this.ui = ui;
    }

    public void markPrice(Integer price){
        this.price = price;
    }

    public abstract Building update(String owner);

    public abstract void updateUI(Position position);
}
