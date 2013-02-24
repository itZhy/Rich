package Prop;

import Player.Feature;
import Player.Movement;
import UI.CommandLine;

public class Barricade extends Prop {
    public Barricade(String owner) {
        name = "路障";
        price = 50;
        element = new Feature().dye(owner, '#');
    }

    public void handle(Movement movement) {
        movement.block(1);
        showPromptMessage();
    }

    private void showPromptMessage() {
        new CommandLine().outputInNewline("遭遇路障，停止前进。");
    }
}
