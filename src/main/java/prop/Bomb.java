package prop;

import org.fusesource.jansi.Ansi;
import player.Movement;
import ui.Element;

public class Bomb extends Prop {
    public Bomb() {
        element = new Element('@');
    }

    public Point price() {
        return new Point(50);
    }

    public void handle(Movement movement) {
        movement.jumpToHospital();
        throw new PropException("您被炸伤送入医院，三回合后出院。");
    }

    public String toString() {
        return "炸弹";
    }
}
