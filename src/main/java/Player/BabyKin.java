package Player;

import UI.UIObserver;
import org.fusesource.jansi.Ansi;

public class BabyKin extends Role {
    private final Ansi.Color color = Ansi.Color.BLUE;

    public BabyKin(Position initialPosition, UIObserver ui, Callback callback) {
        super(initialPosition, ui, callback);
    }

    public String getPromptMessage() {
        return "金贝贝>";
    }

    protected void updateUI(Position source, Position destination) {
        ui.move(source, destination, new RoleColor().dye(name(), 'J'));
    }
}
