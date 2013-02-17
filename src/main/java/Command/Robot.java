package Command;

import Player.Role;
import Props.Manager;
import Props.PropsMap;
import UI.UIException;

public class Robot implements Command {
    private final PropsMap propsMap;
    private final Manager propsManager;

    public Robot(PropsMap propsMap, Manager propsManager)   {
        this.propsMap = propsMap;
        this.propsManager = propsManager;
    }

    public void execute(Role role, int argument)    {
        if (!propsManager.consume(role.name(), new Props.Robot()))   {
             throw new UIException("您尚无机器娃娃道具，请重新输入。");
        }
        propsMap.cleanTheFront(role.offset(0));
    }
}
