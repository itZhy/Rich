package Command;

import Player.Role;
import Props.Barricade;
import Props.PropsManager;
import UI.UIException;

public class Block implements Command {
    private final PropsManager propsManager;

    public Block(PropsManager propsManager) {
        this.propsManager = propsManager;
    }

    public void execute(Role role, int argument) {
        if (!propsManager.put(role.name(), new Barricade(role.name()), role.currentPosition().move(argument))) {
            throw new UIException("您尚无路障道具，请重新输入。");
        }
    }
}
