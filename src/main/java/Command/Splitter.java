package Command;

import Application.GameException;

import java.util.Scanner;

public class Splitter {
    private final Scanner scanner;

    public Splitter(String input) {
        scanner = new Scanner(input);
    }

    public String name() {
        if (scanner.hasNext()) {
            return scanner.next().toLowerCase();
        }
        return "";
    }

    public int argument() {
        if (scanner.hasNextInt())   {
            return scanner.nextInt();
        }
        check();
        return 0;
    }

    private void check() {
        if (scanner.hasNext())  {
            throw new GameException("无法识别的命令参数，请重新输入，命令应该没有参数或者参数是整数。");
        }
    }
}
