package prop;

import player.Movement;
import player.Role;

public class Barricade extends Prop {
    public Barricade(Role owner) {
        name = "路障";
        price = new Point(50);
        element = owner.dye('#');
    }

    public void handle(Movement movement) {
        throw new PropException("遭遇路障，停止前进。");
    }
}
