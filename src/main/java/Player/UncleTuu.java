package Player;

import UI.UIObserver;
import org.fusesource.jansi.Ansi;

public class UncleTuu extends Role {
    private final Ansi.Color color = Ansi.Color.YELLOW;

    public UncleTuu(Position initialPosition, UIObserver ui, Callback callback) {
        super(initialPosition, ui, callback);
    }

    public String getPromptMessage() {
        return "阿土伯>";
    }

    protected void updateUI(Position source, Position destination) {
        ui.move(source, destination, new RoleColor().dye(name(), 'A'));
    }
}
