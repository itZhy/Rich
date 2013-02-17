package Props;

import Player.Feature;
import Player.Position;
import Player.Role;

public class Barricade extends Prop {
    public Barricade(String owner) {
        element = new Feature().dye(owner, '#');
        price = 50;
    }

    public void handle(Position position, Role role)   {
        role.block();
    }
}
