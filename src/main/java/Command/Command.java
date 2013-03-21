package command;

import player.Player;

public interface Command {
    public void execute(Player player, int argument);
}
