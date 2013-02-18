package Command;

import Player.Role;
import Props.PropManager;
import UI.UIException;

public class Robot implements Command {
    private final PropManager propManager;

    public Robot(PropManager propManager) {
        this.propManager = propManager;
    }

    public void execute(Role role, int argument) {
        if (!propManager.clean(role.name(), role.currentPosition())) {
            throw new UIException("您尚无机器娃娃道具，请重新输入。");
        }
    }
}
