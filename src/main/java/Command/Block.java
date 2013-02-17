package Command;

import Player.Role;
import Props.Barricade;
import Props.Ownership;
import Props.PropsMap;
import UI.UIException;

public class Block implements Command {
    private final PropsMap propsMap;
    private final Ownership ownership;

    public Block(PropsMap propsMap, Ownership ownership) {
        this.propsMap = propsMap;
        this.ownership = ownership;
    }

    public void execute(Role role, int argument) {
        if (!ownership.consume(role.name(), new Barricade(role.name()))) {
            throw new UIException("您尚无路障道具，请重新输入。");
        }
        propsMap.put(role.offset(argument), new Barricade(role.name()));
    }
}
