package Player;

import UI.Element;
import org.fusesource.jansi.Ansi;

import java.util.HashMap;
import java.util.Map;

public class Feature {
    private Map<String, Element> features = new HashMap<String, Element>();

    public Feature() {
        features.put(BabyKin.class.toString(),  new Element('B', Ansi.Color.BLUE));
        features.put(MadameChyan.class.toString(), new Element('M', Ansi.Color.MAGENTA));
        features.put(SunHsiaoMei.class.toString(), new Element('S', Ansi.Color.RED));
        features.put(UncleTuu.class.toString(), new Element('S', Ansi.Color.YELLOW));
    }

    public Element get(String name) {
        return features.get(name);
    }

    public Element dye(String name, char symbol) {
        return get(name).dye(symbol);
    }
}
