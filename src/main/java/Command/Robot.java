package Command;

import Player.Role;
import Prop.PropManager;

public class Robot implements Command {
    private final PropManager propManager;

    public Robot(PropManager propManager) {
        this.propManager = propManager;
    }

    public void execute(Role role, int argument) {
        propManager.clean(role.name(), role.currentPosition());
    }
}
