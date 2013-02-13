package Command;

import Player.Player;
import Player.Dice;

public class Roll implements Command {
    private final Dice dice = new Dice();

    public void execute(Player player) {
        player.forward(dice.roll());
    }

    public boolean equals(Object object){
        return getClass() == object.getClass();
    }
}
