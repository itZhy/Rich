package Command;

import Application.GameException;
import Player.Role;
import Prop.Barricade;
import Prop.PropManager;

public class Block implements Command {
    private final PropManager propManager;

    public Block(PropManager propManager) {
        this.propManager = propManager;
    }

    public void execute(Role role, int argument) {
        checkArgument(argument);
        propManager.put(role.name(), new Barricade(role.name()), role.currentPosition().offset(argument));
    }

    private void checkArgument(int argument) {
        if (argument > 10 || argument < -10) {
            throw new GameException("路障只能设置在当前位置前后10步的距离，请重新输入。");
        }
    }
}
