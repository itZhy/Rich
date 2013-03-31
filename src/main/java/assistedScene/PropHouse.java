package assistedScene;

import application.GameException;
import player.Movement;
import player.Role;
import prop.PropManager;
import ui.CommandLine;

public class PropHouse implements Scene {
    private final PropSelectorFactory factory;
    private final CommandLine commandLine = new CommandLine();

    public PropHouse(PropManager propManager) {
        factory = new PropSelectorFactory(propManager);
    }

    public void handle(Role role, Movement movement) {
        showPromptMessage();
        handleInput(role);
    }

    private void handleInput(Role role) {
        while (true) {
            try {
                factory.get(commandLine.waitForInput("请输入您要购买的道具编号：").toLowerCase()).select(role);
                return;
            } catch (GameException e) {
                commandLine.outputInNewline(e.message());
            }
        }
    }

    private void showPromptMessage() {
        commandLine.outputInNewline("欢迎光临道具屋，请选择您所需要的道具：");
        commandLine.outputInNewline("道具\t\t编号\t价值（点数）\n路障\t\t1\t\t50\n机器娃娃\t2\t\t30\n炸弹\t\t3\t\t50");
    }
}
