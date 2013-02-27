package UI;

import Application.GameException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandLine {
    public void output(String message) {
        System.out.print(message);
    }

    public void outputInNewline(String message) {
        System.out.println(message);
    }

    public String waitForInput() {
        return getInput();
    }

    public String waitForInput(String promptMessage) {
        outputInNewline(promptMessage);
        return getInput();
    }

    private String getInput() {
        try {
            return new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            throw new GameException("读取输入失败，请重新输入。");
        }
    }
}
