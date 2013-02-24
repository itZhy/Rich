package Prop;

import Player.Feature;
import Player.Movement;
import UI.CommandLine;

public class Bomb extends Prop {
    public Bomb(String owner) {
        name = "炸弹";
        price = 50;
        element = new Feature().dye(owner, '@');
    }

    public void handle(Movement movement) {
        movement.jumpToHospital();
        showPromptMessage();
    }

    private void showPromptMessage() {
        new CommandLine().outputInNewline("您被炸伤送入医院，三回合后出院。");
    }
}
