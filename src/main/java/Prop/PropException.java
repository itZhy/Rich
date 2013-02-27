package Prop;

import UI.CommandLine;

public class PropException extends RuntimeException {
    private final String message;

    public PropException(String message) {
        this.message = message;
    }

    public void showPromptMessage() {
        new CommandLine().waitForInput(message + " 按任意键继续。");
    }
}
