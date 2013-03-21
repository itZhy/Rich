package command;

import estate.EstateManager;
import player.Position;
import player.Player;

public class Sell implements Command {
    private final EstateManager estateManager;

    public Sell(EstateManager estateManager) {
        this.estateManager = estateManager;
    }

    public void execute(Player player, int argument) {
        estateManager.sell(new Position(argument), player.role());
    }
}
