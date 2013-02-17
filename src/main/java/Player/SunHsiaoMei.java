package Player;

import UI.UIObserver;

public class SunHsiaoMei extends Role {
    public SunHsiaoMei(UIObserver ui, Callback callback) {
        super(ui, callback);
    }

    public String getPromptMessage() {
        return "孙美美>";
    }

    protected void updateUI(Position source, Position destination) {
        ui.move(source, destination, new RoleColor().dye(name(), 'S'));
    }
}
