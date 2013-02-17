package Player;

import Estate.EstateObserver;
import UI.UIObserver;

public class UncleTuu extends Role {
    public UncleTuu(Position initialPosition, UIObserver ui, EstateObserver building) {
        super(initialPosition, ui, building);
    }

    public String getPromptMessage() {
        return "阿土伯>";
    }

    protected void updateUI(Position source, Position destination) {
        ui.move(source, destination, new RoleColor().dye(name(), 'A'));
    }
}
