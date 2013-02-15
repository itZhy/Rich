package Interaction;

import UI.CommandLine;
import UI.UIException;

public class Interaction {
    private final CommandLine commandLine = new CommandLine();
    private Controller controller = null;

    public void run() {
        initializeControllerUntilSucceed();
        handleCommandUntilQuit();
    }

    private void initializeControllerUntilSucceed() {
        while (null == controller && initializeController()) ;
    }

    private boolean initializeController() {
        try {
            commandLine.showPromptMessageInNewline(
                    "请选择2~4位不重复玩家，输入编号即可。(1.钱夫人; 2.阿土伯; 3.孙小美; 4.金贝贝):");
            controller = new Controller(commandLine.waitForInput());
            return true;
        } catch (UIException e) {
            commandLine.showPromptMessageInNewline(e.toString());
            return !e.isNeedQuit();
        }
    }

    private void handleCommandUntilQuit() {
        while (handleCommand()) ;
    }

    private boolean handleCommand() {
        try {
            commandLine.showPromptMessage(controller.getPromptMessageForCurrentPlayer());
            controller.handleCommand(commandLine.waitForInput());
            return true;
        } catch (UIException e) {
            commandLine.showPromptMessageInNewline(e.toString());
            return !e.isNeedQuit();
        }
    }
}