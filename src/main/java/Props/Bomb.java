package Props;

import Player.Position;
import Player.Role;
import UI.UIObserver;
import Player.RoleColor;

public class Bomb extends Prop {
    public Bomb(String owner, UIObserver ui) {
        super(ui);
        element = new RoleColor().dye(owner, '@');
        price = 50;
    }

    public void handle(Position position, Role role) {
        role.moveToHospital();
    }
}
