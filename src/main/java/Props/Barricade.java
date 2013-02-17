package Props;

import Player.Position;
import Player.Role;
import UI.UIObserver;
import Util.RoleColor;

public class Barricade extends Prop {
    public Barricade(String owner, UIObserver ui) {
        super(ui);
        element = new RoleColor().dye(owner, '#');
        price = 50;
    }

    public void handle(Position position, Role role)   {
        role.block();
    }
}
