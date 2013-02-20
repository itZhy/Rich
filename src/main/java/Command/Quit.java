package Command;

import Player.Role;
import UI.UIException;

public class Quit implements Command {
    public void execute(Role role, int argument) {
        throw new UIException("正在退出游戏...", UIException.NEED_NOT_RETRY);
    }
}
