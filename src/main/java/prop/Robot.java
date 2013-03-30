package prop;

import player.Movement;
import player.Position;
import ui.UIObserver;

public class Robot extends Prop {
    public Robot() {
        name = "机器娃娃";
        price = new Point(30);
    }

    public void handle(Movement movement) {
    }

    public void addToUI(UIObserver ui, Position position) {
    }

    public void removeFromUI(UIObserver ui, Position position) {
    }
}