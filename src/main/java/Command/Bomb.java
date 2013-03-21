package command;

import application.GameException;
import player.Player;
import prop.PropManager;

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
        if (argument > 10 || argument < -10) {
            throw new GameException("炸弹只能设置在当前位置前后10步的距离，请重新输入。", GameException.NEED_RETRY);
        }
    }
}
