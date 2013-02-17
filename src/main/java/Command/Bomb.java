package Command;

import Player.Role;
import Props.PropsManager;
import UI.UIException;

public class Bomb implements Command {
    private final PropsManager propsManager;

    public Bomb(PropsManager propsManager) {
        this.propsManager = propsManager;
    }

    public void execute(Role role, int argument) {
        if (!propsManager.put(role.name(), new Props.Bomb(role.name()), role.currentPosition().move(argument))) {
            throw new UIException("您尚无炸弹道具，请重新输入。");
        }
    }
}
