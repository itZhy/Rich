package command;

import player.Player;
import prop.PropManager;
import ui.CommandLine;

public class Robot implements Command {
    private final PropManager propManager;


    public Robot(PropManager propManager) {
        this.propManager = propManager;
    }

    public void execute(Player player, int argument) {
        propManager.clean(player.role(), player.offsetPosition(0));
        showPromptMessage();
    }

    private void showPromptMessage() {
        new CommandLine().outputInNewline("您已使用机器娃娃清理了前方10步内所有道具。");
    }
}
