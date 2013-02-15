package Command;

import Player.Role;
import UI.UIException;

public class Quit implements Command {
    public void execute(Role role) {
        throw new UIException("游戏被中止，正在退出...", UIException.NEED_QUIT);
    }
}
