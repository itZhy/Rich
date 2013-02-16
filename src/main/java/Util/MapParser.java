package Util;

import Player.Position;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MapParser {
    private static final String DEFAULT_MAP_PATH = "default_map";

    public List<Position> readDefaultBuilding() throws FileNotFoundException {
        return readDefaultMapBySymbol('0');
    }

    private List<Position> readDefaultMapBySymbol(char symbol) throws FileNotFoundException {
        List<Position> positions = new ArrayList<Position>();

        String defaultMapStr = new Scanner(new File(DEFAULT_MAP_PATH)).nextLine();
        for (int index = 0; index != defaultMapStr.length(); ++index) {
            if (defaultMapStr.charAt(index) == symbol) {
                positions.add(new Position(index));
            }
        }
        return positions;
    }
}
