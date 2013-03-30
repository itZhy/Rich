package command;

import application.GameException;

import java.util.Scanner;

public class Splitter {
    private final Scanner scanner;
    private final String name;
    private final int argument;

    public Splitter(String input) {
        scanner = new Scanner(input);
        name = parseName();
        argument = parseArgument();
    }

    public String name() {
        return name;
    }

    public int argument() {
        return argument;
    }

    private String parseName() {
        if (scanner.hasNext()) {
            return scanner.next().toLowerCase();
        }
        return "";
    }

    private int parseArgument() {
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        }
        check();
        return 0;
    }

    private void check() {
        if (scanner.hasNext()) {
            throw new GameException("无法识别的命令参数，请重新输入，命令应该没有参数或者参数是整数。",
                    GameException.NEED_RETRY);
        }
    }
}