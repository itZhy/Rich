package player;

import org.fusesource.jansi.Ansi;
import ui.Element;

public enum Role {
    madameChyan("钱夫人", new Element('M', Ansi.Color.MAGENTA)),
    uncleTuu("阿土伯", new Element('U', Ansi.Color.YELLOW)),
    SunHsiaoMei("孙小美", new Element('S', Ansi.Color.RED)),
    babyKin("金贝贝", new Element('B', Ansi.Color.BLUE));
    private final String name;
    private final Element element;

    private Role(String name, Element element) {
        this.name = name;
        this.element = element;
    }

    public Element dye(char symbol) {
        return element.dye(symbol);
    }

    public Element getDisplayElement() {
        return element;
    }

    public String toString() {
        return name;
    }
}
