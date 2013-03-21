package estate;

import player.Role;
import player.Position;
import ui.UIObserver;

abstract class Building {
    final int basePrice;
    Role owner;

    Building(int basePrice) {
        this.basePrice = basePrice;
    }

    public boolean isOwner(Role role) {
        return role.equals(owner);
    }

    public abstract int sellingPrice();

    public abstract Building update(Role owner);

    public abstract int toll();

    public boolean matchOwnerAndType(Role role, Class type) {
        return role.equals(owner) && type.equals(getClass());
    }

    public abstract void updateUI(Position position, UIObserver ui);

    public abstract void clearUI(Position position, UIObserver ui);
}
