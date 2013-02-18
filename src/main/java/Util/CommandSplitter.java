package Util;

import UI.UIException;

import java.util.Scanner;

public class CommandSplitter {
    private final Scanner scanner;

    public CommandSplitter(String input) {
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
            throw new UIException("无法识别的命令参数，请重新输入，命令应该没有参数或者参数是整数。");
        }
    }
}
