package Props;

import Player.Feature;
import Player.Movement;

public class Bomb extends Prop {
    public Bomb(String owner) {
        element = new Feature().dye(owner, '@');
        price = 50;
    }

    public void handle(Movement movement) {
        movement.jumpToHospital();
    }
}
