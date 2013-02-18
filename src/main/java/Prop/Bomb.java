package Prop;

import Player.Feature;
import Player.Movement;

public class Bomb extends Prop {
    public Bomb(String owner) {
        name = "炸弹";
        price = 50;
        element = new Feature().dye(owner, '@');
    }

    public void handle(Movement movement) {
        movement.jumpToHospital();
    }
}
