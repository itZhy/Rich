package Command;

import Player.Role;
import Props.PropsMap;

public class Bomb implements Command{
    private final PropsMap propsMap;

    public Bomb(PropsMap propsMap)   {
        this.propsMap = propsMap;
    }

    public void execute(Role role, int argument)    {
        propsMap.put(role.offset(argument), new Props.Bomb(role.name()));
    }
}
