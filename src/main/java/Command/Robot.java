package Command;

import Player.Role;
import Props.PropsManager;
import UI.UIException;

public class Robot implements Command {
    private final PropsManager propsManager;

    public Robot(PropsManager propsManager) {
        this.propsManager = propsManager;
    }

    public void execute(Role role, int argument) {
        if (!propsManager.clean(role.name(), role.currentPosition())) {
            throw new UIException("您尚无机器娃娃道具，请重新输入。");
        }
    }
}
