package Props;

import Player.Feature;
import Player.Position;
import Player.Role;

public class Bomb extends Prop {
    public Bomb(String owner) {
        element = new Feature().dye(owner, '@');
        price = 50;
    }

    public void handle(Position position, Role role) {
        role.moveToHospital();
    }
}
