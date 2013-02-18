package Estate;

import Player.Position;
import UI.UIObserver;

public abstract class Building {
    protected String owner;
    protected Integer price;
    protected final UIObserver ui;
    protected Integer degree;

    public Building(String role, UIObserver ui) {
        owner = role;
        this.ui = ui;
    }

    public void markPrice(Integer price) {
        this.price = price;
    }

    public Integer sellingPrice() {
        return price * (degree + 1) * 2;
    }

    public abstract Integer toll();

    public abstract Building update(String owner);

    public abstract void updateUI(Position position);
}
