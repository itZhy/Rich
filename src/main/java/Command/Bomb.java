package Command;

import Player.Role;
import Props.PropManager;
import UI.UIException;

public class Bomb implements Command {
    private final PropManager propManager;

    public Bomb(PropManager propManager) {
        this.propManager = propManager;
    }

    public void execute(Role role, int argument) {
        if (!propManager.put(role.name(), new Props.Bomb(role.name()), role.currentPosition().move(argument))) {
            throw new UIException("您尚无炸弹道具，请重新输入。");
        }
    }
}
