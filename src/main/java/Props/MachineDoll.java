package Props;

import Player.Position;
import Player.Role;
import UI.Observer;

public class MachineDoll extends Prop {
    public MachineDoll(Role role, Observer ui) {
        super(ui);
        price = 30;
    }

    public void handle(Role role) {
    }

    public void addToUI(Position position) {
    }

    public void removeFromUI(Position position) {
    }
}