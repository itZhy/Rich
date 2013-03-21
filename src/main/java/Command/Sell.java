package command;

import estate.EstateManager;
import player.Position;
import player.Role;

public class Sell implements Command {
    private final EstateManager estateManager;

    public Sell(EstateManager estateManager) {
        this.estateManager = estateManager;
    }

    public void execute(Role role, int argument) {
        estateManager.sell(new Position(argument), role.name());
    }
}
