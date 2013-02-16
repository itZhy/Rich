package Command;

import Player.Role;
import Player.Dice;

public class Roll implements Command {
    private final Dice dice = new Dice();

    public void execute(Role role, int argument) {
        role.forward(dice.roll());
    }

    public boolean equals(Object object){
        return getClass() == object.getClass();
    }
}
