package Command;

import Player.Player;
import UI.UIException;


public class Quit implements Command {
    public void execute(Player player) {
        throw new UIException("游戏被中止，正在退出...", UIException.NEED_QUIT);
    }
}
