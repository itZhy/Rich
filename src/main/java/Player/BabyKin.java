package Player;

import Estate.EstateObserver;
import UI.UIObserver;
import Util.RoleColor;

public class BabyKin extends Role {
    public BabyKin(Position initialPosition, UIObserver ui, EstateObserver building) {
        super(initialPosition, ui, building);
    }

    public String getPromptMessage() {
        return "金贝贝>";
    }

    protected void updateUI(Position source, Position destination) {
        ui.move(source, destination, new RoleColor().dye(name(), 'J'));
    }
}
