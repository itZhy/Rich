package Command;

import Player.Role;
import Prop.Barricade;
import Prop.PropManager;

public class Block implements Command {
    private final PropManager propManager;

    public Block(PropManager propManager) {
        this.propManager = propManager;
    }

    public void execute(Role role, int argument) {
        propManager.put(role.name(), new Barricade(role.name()), role.currentPosition().move(argument));
    }
}
