package Prop;

import Player.Feature;
import Player.Movement;

public class Barricade extends Prop {
    public Barricade(String owner) {
        element = new Feature().dye(owner, '#');
        price = 50;
    }

    public void handle(Movement movement)   {
        movement.block(1);
    }
}
