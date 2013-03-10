package Estate;

import Player.Position;
import UI.UIObserver;

abstract class Building {
    final int basePrice;
    String owner;

    Building(int basePrice) {
        this.basePrice = basePrice;
    }

    public boolean isOwner(String roleName) {
        return roleName.equals(owner);
    }

    public abstract int sellingPrice();

    public abstract Building update(String owner);

    public abstract int toll();

    public boolean matchOwnerAndType(String role, Class type) {
        return role.equals(owner) && type.equals(getClass());
    }

    public abstract void updateUI(Position position, UIObserver ui);

    public abstract void clearUI(Position position, UIObserver ui);
}
