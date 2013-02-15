package UI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandLine {
    public void showPromptMessage(String message) {
        System.out.print(message);
    }

    public void showPromptMessageInNewline(String message) {
        System.out.println(message);
    }

    public String waitForInput() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new UIException("读取输入失败，请重新输入。");
        }
    }
}
