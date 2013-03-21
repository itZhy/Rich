package command;

import application.GameException;
import player.Player;
import ui.CommandLine;

import java.util.Scanner;

public class Help implements Command {
    private static final String HELP_FILE_PATH = "/help";
    private final CommandLine commandLine = new CommandLine();

    public void execute(Player player, int argument) {
        try {
            showHelpMessage();
        } catch (NullPointerException e) {
            throw new GameException("未找到帮助文件。", GameException.NEED_RETRY);
        }
    }

    private void showHelpMessage() throws NullPointerException {
        Scanner scanner = new Scanner(getClass().getResourceAsStream(HELP_FILE_PATH), "UTF-8");
        while (scanner.hasNext()) {
            commandLine.outputInNewline(scanner.nextLine());
        }
    }
}
