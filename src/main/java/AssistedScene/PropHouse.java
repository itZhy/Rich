package AssistedScene;

import Player.Movement;
import Prop.PropManager;
import UI.CommandLine;

public class PropHouse implements Scene {
    private final PropSelectorFactory factory;
    private final CommandLine commandLine = new CommandLine();

    public PropHouse(PropManager propManager) {
        factory = new PropSelectorFactory(propManager);
    }

    public void handle(String roleName, Movement movement) {
        showPromptMessage();
        while (true)    {
            factory.get(commandLine.waitForInput()).select(roleName);
        }
    }

    private void showPromptMessage() {
        CommandLine commandLine = new CommandLine();
        commandLine.showMessageInNewline("欢迎光临道具屋，请选择您所需要的道具：");
        commandLine.showMessageInNewline("道具\t编号\t价值（点数）\n路障\t1\t50\n机器娃娃\t2\t30\n炸弹\t3\t50");
    }
}
