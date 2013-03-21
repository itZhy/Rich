package command;

import application.GameException;
import player.Player;

public class Quit implements Command {
    public void execute(Player player, int argument) {
        throw new GameException("正在退出游戏...", GameException.NEED_NOT_RETRY);
    }
}
