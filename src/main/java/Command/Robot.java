package Command;

import Player.Role;
import Props.PropsMap;

public class Robot implements Command {
    private final PropsMap propsMap;

    public Robot(PropsMap propsMap)   {
        this.propsMap = propsMap;
    }

    public void execute(Role role, int argument)    {
        propsMap.cleanTheFront(role.offset(0));
    }
}
