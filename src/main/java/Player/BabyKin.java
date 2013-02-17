package Player;

import UI.UIObserver;

public class BabyKin extends Role {
    public BabyKin(UIObserver ui, Callback callback) {
        super(ui, callback);
    }

    public String getPromptMessage() {
        return "金贝贝>";
    }

    protected void updateUI(Position source, Position destination) {
        ui.move(source, destination, new RoleColor().dye(name(), 'J'));
    }
}
