package player;

import ui.Element;
import org.fusesource.jansi.Ansi;

import java.util.HashMap;
import java.util.Map;

public class Feature {
    public static final String MADAME_CHYAN = "钱夫人";
    public static final String UNCLE_TUU = "阿土伯";
    public static final String SUN_HSIAO_MEI = "孙小美";
    public static final String BABY_KIN = "金贝贝";
    private final Map<String, Element> features = new HashMap<String, Element>();

    public Feature() {
        features.put(MADAME_CHYAN, new Element('M', Ansi.Color.MAGENTA));
        features.put(UNCLE_TUU, new Element('U', Ansi.Color.YELLOW));
        features.put(SUN_HSIAO_MEI, new Element('S', Ansi.Color.RED));
        features.put(BABY_KIN, new Element('B', Ansi.Color.BLUE));
    }

    public Element get(String name) {
        return features.get(name);
    }

    public Element dye(String name, char symbol) {
        return get(name).dye(symbol);
    }
}
