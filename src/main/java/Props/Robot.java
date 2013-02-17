package Props;

import Player.Position;
import Player.Role;
import UI.UIObserver;

public class Robot extends Prop {
    public Robot() {
        price = 30;
    }

    public void handle(Position position, Role role) {
    }

    public void addToUI(UIObserver ui, Position position) {
    }

    public void removeFromUI(UIObserver ui, Position position) {
    }
}