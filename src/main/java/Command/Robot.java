package command;

import player.Role;
import prop.PropManager;
import ui.CommandLine;

public class Robot implements Command {
    private final PropManager propManager;

    public Robot(PropManager propManager) {
        this.propManager = propManager;
    }

    public void execute(Role role, int argument) {
        propManager.clean(role.name(), role.currentPosition());
        showPromptMessage();

    }

    private void showPromptMessage() {
        new CommandLine().outputInNewline("您已使用机器娃娃清理了前方10步内所有道具。");
    }
}
