package Interaction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Interaction {

    private Controller controller;

    public void run() {
        initializePlayers();
        handleCommand();
    }

    private void initializePlayers() {
        try {
            showPromptMessage("请选择2~4位不重复玩家，输入编号即可。(1.钱夫人; 2.阿土伯; 3.孙小美; 4.金贝贝):");
            controller = new Controller(waitForInput());
        } catch (Exception e) {
            showPromptMessage(e.toString());
        }
    }

    private void handleCommand() {
        while (true) {
            try {
                controller.showPromptMessageForCurrentPlayer();
                controller.handle(waitForInput());
            } catch (Exception e) {
                showPromptMessage(e.toString());
            }
        }
    }

    private String waitForInput() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new Exception("读取输入失败，请重新输入。");
        }
    }

    private void showPromptMessage(String message) {
        System.out.println(message);
    }
}
