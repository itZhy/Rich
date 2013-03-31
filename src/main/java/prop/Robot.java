package prop;

import player.Movement;

public class Robot extends Prop {
    public Point price() {
        return new Point(30);
    }

    public void handle(Movement movement) {
    }

    public String toString() {
        return "机器娃娃";
    }
}