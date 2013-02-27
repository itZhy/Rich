package Prop;

import Player.Feature;
import Player.Movement;

public class Barricade extends Prop {
    public Barricade(String owner) {
        name = "路障";
        price = 50;
        element = new Feature().dye(owner, '#');
    }

    public void handle(Movement movement) {
        throw new PropException("遭遇路障，停止前进。");
    }
}
