package Command;

import Estate.Estate;
import Player.Position;
import Player.Role;

public class Sell implements Command {
    private final Estate estate;

    public Sell(Estate estate) {
        this.estate = estate;
    }

    public void execute(Role role, int argument) {
       estate.sell(new Position(argument), role.getClass().toString());
    }

    public boolean equals(Object object){
        return getClass() == object.getClass();
    }
}
