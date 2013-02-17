package Player;

import UI.UIObserver;

public class UncleTuu extends Role {
    public UncleTuu(UIObserver ui, Callback callback) {
        super(ui, callback);
    }

    public String getPromptMessage() {
        return "阿土伯>";
    }

    protected void updateUI(Position source, Position destination) {
        ui.move(source, destination, new RoleColor().dye(name(), 'A'));
    }
}
