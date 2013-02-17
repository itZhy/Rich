package Command;

import Player.Role;
import Props.Barricade;
import Props.PropsMap;

public class Block implements Command {
    private final PropsMap propsMap;

    public Block(PropsMap propsMap)   {
        this.propsMap = propsMap;
    }

    public void execute(Role role, int argument)    {
        propsMap.put(role.offset(argument), new Barricade(role.name()));
    }
}
