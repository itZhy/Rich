package UI;

import Player.Position;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PositionExtractor {
    private static final String DEFAULT_MAP_PATH = "default_map";

    public List<Position> getBuildings() {
        return readDefaultMapBySymbol('0');
    }

    public List<Position> getPointsPools() {
        return readDefaultMapBySymbol('$');
    }

    public Position getHospital() {
        return readDefaultMapBySymbol('H').get(0);
    }

    public Position getPrison() {
        return readDefaultMapBySymbol('P').get(0);
    }

    public Position getMagicHouse() {
        return readDefaultMapBySymbol('M').get(0);
    }

    public Position getPropHouse() {
        return readDefaultMapBySymbol('T').get(0);
    }

    public Position getGiftHouse() {
        return readDefaultMapBySymbol('G').get(0);
    }

    private List<Position> readDefaultMapBySymbol(char symbol) {
        try {
            String defaultMapStr = new Scanner(new File(DEFAULT_MAP_PATH)).nextLine();
            return extract(defaultMapStr, symbol);

        } catch (FileNotFoundException e) {
            throw new UIException(DEFAULT_MAP_PATH + "不存在。", UIException.NEED_NOT_RETRY);
        }
    }

    private List<Position> extract(String defaultMapStr, char symbol) {
        List<Position> positions = new ArrayList<Position>();
        for (int index = 0; index != defaultMapStr.length(); ++index) {
            if (defaultMapStr.charAt(index) == symbol) {
                positions.add(new Position(index));
            }
        }
        return positions;
    }
}