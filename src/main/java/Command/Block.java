package Command;

import Player.Role;
import Prop.Barricade;
import Prop.PropManager;
import UI.UIException;

public class Block implements Command {
    private final PropManager propManager;

    public Block(PropManager propManager) {
        this.propManager = propManager;
    }

    public void execute(Role role, int argument) {
        if (!propManager.put(role.name(), new Barricade(role.name()), role.currentPosition().move(argument))) {
            throw new UIException("您尚无路障道具，请重新输入。");
        }
    }
}
