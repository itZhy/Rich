package Prop;

import Player.Movement;
import Player.Position;
import UI.UIObserver;

public class Robot extends Prop {
    public Robot() {
        name = "机器娃娃";
        price = 30;
    }

    public void handle(Movement movement) {
    }

    public void addToUI(UIObserver ui, Position position) {
    }

    public void removeFromUI(UIObserver ui, Position position) {
    }
}