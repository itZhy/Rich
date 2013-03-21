package assistedScene;

import player.Movement;
import ui.CommandLine;

public class MagicHouse implements Scene {
    public void handle(String roleName, Movement movement) {
        showPromptMessage();
    }

    private void showPromptMessage() {
        new CommandLine().outputInNewline("您到达了魔法屋，什么都没有发生。");
    }
}
