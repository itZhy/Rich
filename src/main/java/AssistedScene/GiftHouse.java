package assistedScene;

import application.GameException;
import estate.EstateManager;
import player.Movement;
import player.Role;
import prop.PropManager;
import ui.CommandLine;

public class GiftHouse implements Scene {
    private final GiftSelectorFactory factory;
    private final CommandLine commandLine = new CommandLine();

    public GiftHouse(PropManager propManager, EstateManager estateManager) {
        factory = new GiftSelectorFactory(propManager, estateManager);
    }

    public void handle(Role role, Movement movement) {
        showPromptMessage();
        handleInput(role);
    }

    private void handleInput(Role role) {
        try {
            factory.get(commandLine.waitForInput("请输入您要选择的礼品编号：")).select(role);
        } catch (GameException e) {
            commandLine.outputInNewline(e.toString());
        }
    }

    private void showPromptMessage() {
        commandLine.outputInNewline("欢迎光临礼品屋，请选择一件您 喜欢的礼品：");
        commandLine.outputInNewline("礼品\t编号\n奖 金\t1\n点数卡\t2\n福 神\t3\n");
    }
}
