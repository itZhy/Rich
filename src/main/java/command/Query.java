package command;

import estate.EstateManager;
import player.Player;
import prop.PropManager;
import ui.CommandLine;

public class Query implements Command {
    private final EstateManager estateManager;
    private final PropManager propManager;

    public Query(EstateManager estateManager, PropManager propManager) {
        this.estateManager = estateManager;
        this.propManager = propManager;
    }

    public void execute(Player player, int argument) {
        new CommandLine().outputInNewline(propManager.query(player.role()) + estateManager.query((player.role())));
    }
}
