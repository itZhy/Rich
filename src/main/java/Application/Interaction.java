package application;

import ui.CommandLine;

public class Interaction {
    private final CommandLine commandLine = new CommandLine();
    private Controller controller = null;

    public void run() {
        initializeController();
        setInitialFund();
        handleCommand();
    }

    private void initializeController() {
        while (true) {
            try {
                controller = new Controller(commandLine.waitForInput(
                        "请选择2~4位不重复玩家，输入编号即可。(1.钱夫人; 2.阿土伯; 3.孙小美; 4.金贝贝):"));
                return;
            } catch (GameException e) {
                commandLine.outputInNewline(e.toString());
            }
        }
    }

    private void setInitialFund() {
        while (true) {
            try {
                String input = commandLine.waitForInput("请输入玩家初始资金，范围1000～50000（默认10000）");
                setInitialFundByInput(input);
                return;
            } catch (GameException e) {
                commandLine.outputInNewline(e.toString());
            }
        }
    }

    private void setInitialFundByInput(String input) {
        if (input.isEmpty()) {
            return;
        }
        controller.initialFund(input);
    }

    private void handleCommand() {
        while (true) {
            try {
                commandLine.output(controller.getPrompt());
                controller.handleCommand(commandLine.waitForInput());
            } catch (GameException e) {
                commandLine.outputInNewline(e.toString());
                if (!e.isNeedRetry()) {
                    return;
                }
            }
        }
    }
}