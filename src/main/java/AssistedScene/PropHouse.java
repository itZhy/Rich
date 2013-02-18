package AssistedScene;

import Player.Movement;
import Prop.PropManager;
import UI.CommandLine;
import UI.UIException;

public class PropHouse implements Scene {
    private final PropSelectorFactory factory;
    private final CommandLine commandLine = new CommandLine();

    public PropHouse(PropManager propManager) {
        factory = new PropSelectorFactory(propManager);
    }

    public void handle(String roleName, Movement movement) {
        showPromptMessage();
        handleInputUntilQuit(roleName);
    }

    private void handleInputUntilQuit(String roleName) {
        while (handleInput(roleName));
    }

    private boolean handleInput(String roleName) {
        try {
            factory.get(commandLine.waitForInput()).select(roleName);
            return true;
        } catch (UIException e) {
            commandLine.output(e.getMessage());
            return e.isNeedRetry();
        }
    }

    private void showPromptMessage() {
        CommandLine commandLine = new CommandLine();
        commandLine.outputInNewline("欢迎光临道具屋，请选择您所需要的道具：");
        commandLine.outputInNewline("道具\t\t编号\t价值（点数）\n路障\t\t1\t\t50\n机器娃娃\t2\t\t30\n炸弹\t\t3\t\t50");
    }
}
