package Player;

import UI.UIObserver;
import org.fusesource.jansi.Ansi;

public class MadameChyan extends Role {
    public MadameChyan(UIObserver ui, Callback callback) {
        super(ui, callback);
    }

    public String getPromptMessage() {
        return "钱夫人>";
    }

    protected void updateUI(Position source, Position destination) {
        ui.move(source, destination, new RoleColor().dye(name(), 'Q'));
    }
}