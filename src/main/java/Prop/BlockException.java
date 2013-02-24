package Prop;

import UI.CommandLine;

public class BlockException extends RuntimeException {
    public void showPromptMessage() {
        new CommandLine().outputInNewline("遭遇路障，停止前进。");
    }
}
