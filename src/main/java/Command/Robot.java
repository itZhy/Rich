package Command;

import Player.Role;
import Props.Ownership;
import Props.PropsMap;
import UI.UIException;

public class Robot implements Command {
    private final PropsMap propsMap;
    private final Ownership ownership;

    public Robot(PropsMap propsMap, Ownership ownership)   {
        this.propsMap = propsMap;
        this.ownership = ownership;
    }

    public void execute(Role role, int argument)    {
        if (!ownership.consume(role.name(), new Props.Robot()))   {
             throw new UIException("您尚无机器娃娃道具，请重新输入。");
        }
        propsMap.cleanTheFront(role.offset(0));
    }
}
