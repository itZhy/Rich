package Player;

import Estate.EstateObserver;
import UI.UIObserver;
import Util.RoleColor;

public class SunHsiaoMei extends Role {
    public SunHsiaoMei(Position initialPosition, UIObserver ui, EstateObserver building) {
        super(initialPosition, ui, building);
    }

    public String getPromptMessage() {
        return "孙美美>";
    }

    protected void updateUI(Position source, Position destination) {
        ui.move(source, destination, new RoleColor().dye(name(), 'S'));
    }
}
