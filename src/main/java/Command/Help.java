package command;

import application.GameException;
import player.Role;
import ui.CommandLine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Help implements Command {
    private static final String HELP_FILE_PATH = "help";
    private final CommandLine commandLine = new CommandLine();

    public void execute(Role role, int argument) {
        try {
            showHelpMessage();
        } catch (FileNotFoundException e) {
            throw new GameException("未找到帮助文件。", GameException.NEED_RETRY);
        }
    }

    private void showHelpMessage() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(HELP_FILE_PATH), "UTF-8");
        while (scanner.hasNext()) {
            commandLine.outputInNewline(scanner.nextLine());
        }
    }
}
