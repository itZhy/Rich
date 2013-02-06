package Command;

import Player.Player;

public class Quit implements Command{
    public void execute(Player player) {
        System.exit(0);
    }
}
