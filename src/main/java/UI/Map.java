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

    public void display() {
        surface.display();
    }

    public void add(Position position, Element element) {
        surface.add(converter.convert(position), element);
    }

    public void move(Position source, Position destination, Element element) {
        surface.remove(converter.convert(source), element);
        surface.add(converter.convert(destination), element);
    }

    public boolean equals(Object object) {
        return Map.class == object.getClass() &&
                surface.equals(((Map) object).surface);
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
            add(new Position(index), new Element(defaultMapStr.charAt(index), Ansi.Color.WHITE));
        }
    }
}
