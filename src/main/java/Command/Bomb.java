package Command;

import Player.Role;
import Prop.PropManager;

public class Bomb implements Command {
    private final PropManager propManager;

    public Bomb(PropManager propManager) {
        this.propManager = propManager;
    }

    public void execute(Role role, int argument) {
        propManager.put(role.name(), new Prop.Bomb(role.name()), role.currentPosition().move(argument));
    }
}
