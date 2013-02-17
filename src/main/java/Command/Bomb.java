package Command;

import Player.Role;
import Props.Manager;
import Props.PropsMap;
import UI.UIException;

public class Bomb implements Command{
    private final PropsMap propsMap;
    private final Manager propsManager;

    public Bomb(PropsMap propsMap, Manager propsManager)   {
        this.propsMap = propsMap;
        this.propsManager = propsManager;
    }

    public void execute(Role role, int argument)    {
        if (!propsManager.consume(role.name(), new Props.Bomb(role.name())))    {
            throw new UIException("您尚无炸弹道具，请重新输入。");
        }
        propsMap.put(role.offset(argument), new Props.Bomb(role.name()));
    }
}
