package Command;

import Estate.EstateManager;
import Player.Position;
import Player.Role;

public class Sell implements Command {
    private final EstateManager estateManager;

    public Sell(EstateManager estateManager) {
        this.estateManager = estateManager;
    }

    public void execute(Role role, int argument) {
        estateManager.sell(new Position(argument), role.name());
    }
}
