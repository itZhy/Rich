package application;

import ui.CommandLine;

public class Interaction {
    private final CommandLine commandLine = new CommandLine();
    private Controller controller;

    public void run() {
        initializeController();
        setInitialFund();
        acceptCommands();
    }

    private void initializeController() {
        while (true) {
            try {
                controller = new Controller(commandLine.waitForInput(
                        "请选择2~4位不重复玩家，输入编号即可。(1.钱夫人; 2.阿土伯; 3.孙小美; 4.金贝贝):"));
                return;
            } catch (GameException e) {
                commandLine.outputInNewline(e.message());
            }
        }
    }

    private void setInitialFund() {
        while (true) {
            try {
                setInitialFundByInput(commandLine.waitForInput("请输入玩家初始资金，范围1000～50000（默认10000）"));
                return;
            } catch (GameException e) {
                commandLine.outputInNewline(e.message());
            }
        }
    }

    private void setInitialFundByInput(String input) {
        if (input.isEmpty()) {
            return;
        }
        controller.initialFund(input);
    }

    private void acceptCommands() {
        while (true) {
            String command = getCommandString();
            if ("quit".equals(command.toLowerCase())) {
                commandLine.outputInNewline("正在退出游戏......");
                break;
            }
            handleCommand(command);
        }
    }

    private String getCommandString() {
        commandLine.output(controller.getPrompt());
        return commandLine.waitForInput();
    }

    private void handleCommand(String command) {
        try {
            controller.handleCommand(command);
        } catch (GameException e) {
            commandLine.outputInNewline(e.message());
        }
    }
}