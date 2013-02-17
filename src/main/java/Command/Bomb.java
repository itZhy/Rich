package Command;

import Player.Role;
import Props.Ownership;
import Props.PropsMap;
import UI.UIException;

public class Bomb implements Command{
    private final PropsMap propsMap;
    private final Ownership ownership;

    public Bomb(PropsMap propsMap, Ownership ownership)   {
        this.propsMap = propsMap;
        this.ownership = ownership;
    }

    public void execute(Role role, int argument)    {
        if (!ownership.consume(role.name(), new Props.Bomb(role.name())))    {
            throw new UIException("您尚无炸弹道具，请重新输入。");
        }
        propsMap.put(role.currentPosition().move(argument), new Props.Bomb(role.name()));
    }
}
