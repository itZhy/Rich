package prop;

import player.Role;
import player.Movement;

public class Barricade extends Prop {
    public Barricade(Role owner) {
        name = "路障";
        price = 50;
        element = owner.dye('#');
    }

    public void handle(Movement movement) {
        throw new PropException("遭遇路障，停止前进。");
    }
}
