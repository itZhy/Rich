package Props;

import Player.Position;
import Player.Role;
import Player.RoleColor;

public class Barricade extends Prop {
    public Barricade(String owner) {
        element = new RoleColor().dye(owner, '#');
        price = 50;
    }

    public void handle(Position position, Role role)   {
        role.block();
    }
}
