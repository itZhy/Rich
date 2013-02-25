package Command;

import Application.GameException;
import Player.Role;
import Prop.PropManager;

public class Bomb implements Command {
    private final PropManager propManager;

    public Bomb(PropManager propManager) {
        this.propManager = propManager;
    }

    public void execute(Role role, int argument) {
        checkArgument(argument);
        propManager.put(role.name(), new Prop.Bomb(role.name()), role.currentPosition().move(argument));
    }

    private void checkArgument(int argument) {
        if (argument > 10 || argument < -10) {
            throw new GameException("炸弹只能设置在当前位置前后10步的距离，请重新输入。");
        }
    }
}
