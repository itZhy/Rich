package Application;

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
        while (!initializeController()) ;
        while (!setInitialFundUntilSucceed());
    }

    private boolean initializeController() {
        try {
            controller = new Controller(commandLine.waitForInput(
                    "请选择2~4位不重复玩家，输入编号即可。(1.钱夫人; 2.阿土伯; 3.孙小美; 4.金贝贝):"));
            return true;
        } catch (UIException e) {
            commandLine.outputInNewline(e.toString());
            return !e.isNeedRetry();
        }
    }

    private boolean setInitialFundUntilSucceed() {
        try {
            String input = commandLine.waitForInput("请输入玩家初始资金，范围1000～50000（默认10000）");
            if (input.isEmpty())    {
                return true;
            }
            controller.initialFund(input);
            return true;
        } catch (UIException e) {
            commandLine.outputInNewline(e.toString());
            return !e.isNeedRetry();
        }
    }

    private void handleCommandUntilQuit() {
        while (handleCommand()) ;
    }

    private boolean handleCommand() {
        try {
            commandLine.output(controller.getPromptMessageForCurrentPlayer());
            controller.handleCommand(commandLine.waitForInput());
            return true;
        } catch (UIException e) {
            commandLine.waitForInput(e.toString());
            return e.isNeedRetry();
        }
    }
}