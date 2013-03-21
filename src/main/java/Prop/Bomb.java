package prop;

import player.Role;
import player.Movement;

public class Bomb extends Prop {
    public Bomb(Role owner) {
        name = "炸弹";
        price = 50;
        element = owner.dye('@');
    }

    public void handle(Movement movement) {
        movement.jumpToHospital();
        throw new PropException("您被炸伤送入医院，三回合后出院。");
    }
}
