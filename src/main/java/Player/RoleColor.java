package Player;

import Player.BabyKin;
import Player.MadameChyan;
import Player.SunHsiaoMei;
import Player.UncleTuu;
import UI.Element;
import org.fusesource.jansi.Ansi;

import java.util.HashMap;
import java.util.Map;

public class RoleColor {
    private Map<String, Ansi.Color> nameToColor = new HashMap<String, Ansi.Color>();

    public RoleColor() {
        nameToColor.put(BabyKin.class.toString(), Ansi.Color.BLUE);
        nameToColor.put(MadameChyan.class.toString(), Ansi.Color.MAGENTA);
        nameToColor.put(SunHsiaoMei.class.toString(), Ansi.Color.RED);
        nameToColor.put(UncleTuu.class.toString(), Ansi.Color.YELLOW);
    }

    public Ansi.Color get(String name) {
        return nameToColor.get(name);
    }

    public Element dye(String name, char symbol) {
        return new Element(symbol, get(name));
    }
}
