package Estate;

import Player.Position;
import Player.Role;
import Player.RoleColor;
import UI.UIObserver;

public class Villa extends Building {
    public Villa(String role, UIObserver ui, Integer price){
        super(role, ui);
        this.price = price;
    }

    public Building update(String owner) {
      return null;
    }

    public void updateUI(Position position) {
        ui.replace(position, new RoleColor().dye(owner, '1'), new RoleColor().dye(owner, '2'));
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                owner.equals(((Villa) object).owner) &&
                ui.equals(((Villa) object).ui);
    }
}
