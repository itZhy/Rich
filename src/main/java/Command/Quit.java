package command;

import application.GameException;
import player.Role;

public class Quit implements Command {
    public void execute(Role role, int argument) {
        throw new GameException("正在退出游戏...", GameException.NEED_NOT_RETRY);
    }
}
