package UI;

import Application.GameException;
import Player.Position;
import org.fusesource.jansi.Ansi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Map implements UIObserver {
    private final Surface surface = new Surface();
    private final Converter converter = new Converter();
    private static final String DEFAULT_MAP_PATH = "default_map";

    public Map() {
        initializeDefaultMap();
    }

    public void refresh() {
        surface.display();
    }

    public void add(Position position, Element element) {
        surface.add(converter.convert(position), element);
    }

    public void delete(Position position, Element element) {
        surface.remove(converter.convert(position), element);
    }

    public void move(Position source, Position destination, Element element) {
        delete(source, element);
        add(destination, element);
    }

    public void replace(Position position, Element oldElement, Element newElement) {
        delete(position, oldElement);
        add(position, newElement);
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                surface.equals(((Map) object).surface);
    }

    private void initializeDefaultMap() {
        try {
            readDefaultMap();
        } catch (FileNotFoundException e) {
            throw new GameException(DEFAULT_MAP_PATH + "不存在", GameException.NEED_NOT_RETRY);
        }
    }

    private void readDefaultMap() throws FileNotFoundException {
        String defaultMapStr = new Scanner(new File(DEFAULT_MAP_PATH)).nextLine();
        for (int index = 0; index != defaultMapStr.length(); ++index) {
            add(new Position(index), new Element(defaultMapStr.charAt(index), Ansi.Color.WHITE));
        }
    }
}
