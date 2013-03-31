package prop;

import player.Movement;
import ui.Element;

public class Barricade extends Prop {
    public Barricade() {
        element = new Element('#');
    }

    public Point price() {
        return new Point(50);
    }

    public void handle(Movement movement) {
        throw new PropException("遭遇路障，停止前进。");
    }

    public String toString() {
        return "路障";
    }
}
