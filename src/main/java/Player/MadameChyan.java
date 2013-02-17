package Player;

import Estate.EstateObserver;
import UI.UIObserver;
import Util.RoleColor;

public class MadameChyan extends Role {
    public MadameChyan(Position initialPosition, UIObserver ui, EstateObserver building) {
        super(initialPosition, ui, building);
    }

    public String getPromptMessage() {
        return "钱夫人>";
    }

    protected void updateUI(Position source, Position destination) {
        ui.move(source, destination, new RoleColor().dye(name(), 'Q'));
    }
}