package ui;

import application.GameException;
import player.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PositionExtractor {
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
        final String DEFAULT_MAP_PATH = "/default_map";
        try {
            String defaultMapStr = new Scanner(getClass().getResourceAsStream(DEFAULT_MAP_PATH)).nextLine();
            return extract(defaultMapStr, symbol);
        } catch (NullPointerException e) {
            throw new GameException(DEFAULT_MAP_PATH + "不存在。");
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