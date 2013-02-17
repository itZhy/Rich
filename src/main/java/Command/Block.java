package Command;

import Player.Role;
import Props.Barricade;
import Props.Manager;
import Props.PropsMap;
import UI.UIException;

public class Block implements Command {
    private final PropsMap propsMap;
    private final Manager propsManager;

    public Block(PropsMap propsMap, Manager propsManager) {
        this.propsMap = propsMap;
        this.propsManager = propsManager;
    }

    public void execute(Role role, int argument) {
        if (!propsManager.consume(role.name(), new Barricade(role.name()))) {
            throw new UIException("您尚无路障道具，请重新输入。");
        }
        propsMap.put(role.offset(argument), new Barricade(role.name()));
    }
}
