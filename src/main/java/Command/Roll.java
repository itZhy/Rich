package Command;

import Player.Die;
import Player.Player;

public class Roll implements Command {
    private final Die die = new Die();

    public void execute(Player player) {
        player.rehabilitatePrevElement();
        player.forward(die.roll());
        player.update();
    }
}
