package command;

import application.GameException;
import player.Player;
import ui.CommandLine;

import java.util.Scanner;

public class Help implements Command {
    private final CommandLine commandLine = new CommandLine();

    public void execute(Player player, int argument) {
        try {
            showHelpMessage();
        } catch (NullPointerException e) {
            throw new GameException("未找到帮助文件。");
        }
    }

    private void showHelpMessage() {
        Scanner scanner = new Scanner(getClass().getResourceAsStream("/help"), "UTF-8");
        while (scanner.hasNext()) {
            commandLine.outputInNewline(scanner.nextLine());
        }
    }
}
