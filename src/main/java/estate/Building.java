package estate;

import player.Position;
import player.Role;
import ui.UIObserver;

abstract class Building {
    final Money basePrice;
    Role owner;

    Building(Money basePrice) {
        this.basePrice = basePrice;
    }

    public boolean isOwner(Role role) {
        return role.equals(owner);
    }

    public abstract Money sellingPrice();

    public abstract Building update(Role owner);

    public abstract Money toll();

    public boolean matchOwnerAndType(Role role, Class type) {
        return role.equals(owner) && type.equals(getClass());
    }

    public abstract void updateUI(Position position, UIObserver ui);

    public abstract void clearUI(Position position, UIObserver ui);
}
