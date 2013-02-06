package UI;

import Player.Position;
import org.fusesource.jansi.Ansi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Map implements Observer {
    private final Surface surface = new Surface();
    private final Converter converter = new Converter();
    private final String DEFAULT_MAP_PATH = "default_map";

    public Map() {
        initializeDefaultMap();
    }

    public void show() {
        surface.display();
    }

    public void set(Position position, Element element) {
        surface.set(converter.convert(position), element);
    }

    private void initializeDefaultMap() {
        try {
            readDefaultMap();
        } catch (FileNotFoundException e) {
            throw new Exception(e.toString());
        }
    }

    private void readDefaultMap() throws FileNotFoundException {
        String defaultMapStr = new Scanner(new File(DEFAULT_MAP_PATH)).nextLine();
        for (int index = 0; index != defaultMapStr.length(); ++index) {
            set(new Position(index), new Element(defaultMapStr.charAt(index), Ansi.Color.WHITE));
        }
    }

    public void update(Position position, Element element) {
        set(position, element);
    }

    public Element get(Position position) {
        return surface.get(converter.convert(position));
    }

    public void add(Position position, Element element) {
    }

    public void remove(Position position, Element element) {
    }
}
