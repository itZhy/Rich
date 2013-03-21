package application;

import ui.CommandLine;

public class Interaction {
    private final CommandLine commandLine = new CommandLine();
    private Controller controller = null;

    public void run() {
        initializeControllerUntilSucceed();
        handleCommandUntilQuit();
    }

    private void initializeControllerUntilSucceed() {
        while (initializeController()) {
        }
        while (setInitialFund()) {
        }
    }

    private boolean initializeController() {
        try {
            controller = new Controller(commandLine.waitForInput(
                    "请选择2~4位不重复玩家，输入编号即可。(1.钱夫人; 2.阿土伯; 3.孙小美; 4.金贝贝):"));
            return false;
        } catch (GameException e) {
            commandLine.outputInNewline(e.toString());
            return e.isNeedRetry();
        }
    }

    private boolean setInitialFund() {
        try {
            String input = commandLine.waitForInput("请输入玩家初始资金，范围1000～50000（默认10000）");
            setInitialFundByInput(input);
            return false;
        } catch (GameException e) {
            commandLine.outputInNewline(e.toString());
            return e.isNeedRetry();
        }
    }

    private void setInitialFundByInput(String input) {
        if (input.isEmpty()) {
            return;
        }
        controller.initialFund(input);
    }

    private void handleCommandUntilQuit() {
        while (handleCommand()) {
        }
    }

    private boolean handleCommand() {
        try {
            commandLine.output(controller.getPrompt());
            controller.handleCommand(commandLine.waitForInput());
            return true;
        } catch (GameException e) {
            commandLine.outputInNewline(e.toString());
            return e.isNeedRetry();
        }
    }
}