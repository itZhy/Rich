package ui;

import application.GameException;
import player.Position;
import utils.Checker;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Converter {
    private final String CONFIG_FILE_PATH = "/position_to_surface_index";
    private final Map<Position, Integer> positionToSurfaceIndex = new HashMap<Position, Integer>();

    public Converter() {
        initializePositionToSurfaceIndex();
    }

    public int convert(Position position) {
        Checker.check(positionToSurfaceIndex.containsKey(position), CONFIG_FILE_PATH + "的内容不正确。");
        return positionToSurfaceIndex.get(position);
    }

    private void initializePositionToSurfaceIndex() {
        try {
            readConfigFile();
        } catch (NullPointerException e) {
            throw new GameException(CONFIG_FILE_PATH + "文件不存在。");
        }
    }

    private void readConfigFile() throws NullPointerException {
        Scanner scanner = new Scanner(getClass().getResourceAsStream(CONFIG_FILE_PATH));
        while (scanner.hasNext()) {
            positionToSurfaceIndex.put(new Position(scanner.nextInt()), scanner.nextInt());
        }
    }
}
