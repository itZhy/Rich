package Player;

import UI.UIObserver;
import org.fusesource.jansi.Ansi;

public class SunHsiaoMei extends Role {
    private final Ansi.Color color = Ansi.Color.YELLOW;

    public SunHsiaoMei(Position initialPosition, UIObserver ui, Observer building) {
        super(initialPosition, ui, building);
    }

    public String getPromptMessage() {
        return "孙美美>";
    }

    protected void updateUI(Position source, Position destination) {
        ui.move(source, destination, new RoleColor().dye(name(), 'S'));
    }
}
