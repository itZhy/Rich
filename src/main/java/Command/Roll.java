package command;

import player.Dice;
import player.Role;
import player.Rounder;

public class Roll implements Command {
    private final Dice dice = new Dice();
    private final Rounder rounder;

    public Roll(Rounder rounder) {
        this.rounder = rounder;
    }

    public void execute(Role role, int argument) {
        role.forward(dice.roll());
        rounder.next();
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass();
    }
}
