package Player;

import UI.UIObserver;
import org.fusesource.jansi.Ansi;

public class MadameChyan extends Role {
    private final Ansi.Color color = Ansi.Color.MAGENTA;

    public MadameChyan(Position initialPosition, UIObserver ui, Observer building) {
        super(initialPosition, ui, building);
    }

    public String getPromptMessage() {
        return "钱夫人>";
    }

    protected void updateUI(Position source, Position destination) {
        ui.move(source, destination, new RoleColor().dye(name(), 'Q'));
    }
}