package command;

import player.Player;
import prop.PropManager;
import utils.Checker;

public class Bomb implements Command {
    private final PropManager propManager;

    public Bomb(PropManager propManager) {
        this.propManager = propManager;
    }

    public void execute(Player player, int argument) {
        checkArgument(argument);
        propManager.put(player.role(), new prop.Bomb(player.role()), player.currentPosition().offset(argument));
    }

    private void checkArgument(int argument) {
        Checker.check(argument <= 10 || argument >= -10, "炸弹只能设置在当前位置前后10步的距离，请重新输入。");
    }
}
