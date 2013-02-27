package Estate;

import Player.Position;
import UI.UIObserver;

public abstract class Building {
    protected String owner;
    protected int basePrice;

    public Building(int basePrice) {
        this.basePrice = basePrice;
    }

    public abstract int sellingPrice();

    public abstract Building update(String owner);

    public abstract int toll();

    public boolean matchOwnerAndType(String role, String type) {
        return role.equals(owner) && type.equals(getClass().toString());
    }

    public abstract void updateUI(Position position, UIObserver ui);

    public abstract void clearUI(Position position, UIObserver ui);
}
