package UI;

import Application.GameException;
import Player.Position;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Converter {
    private final String CONFIG_FILE_PATH = "position_to_surface_index";
    private final Map<Position, Integer> positionToSurfaceIndex = new HashMap<Position, Integer>();

    public Converter() {
        initializePositionToSurfaceIndex();
    }

    public int convert(Position position) {
        if (null == positionToSurfaceIndex.get(position)) {
            throw new GameException(CONFIG_FILE_PATH + "的内容不正确。", GameException.NEED_NOT_RETRY);
        }

        return positionToSurfaceIndex.get(position);
    }

    private void initializePositionToSurfaceIndex() {
        try {
            readConfigFile();
        } catch (FileNotFoundException e) {
            throw new GameException(CONFIG_FILE_PATH + "文件不存在。", GameException.NEED_NOT_RETRY);
        }
    }

    private void readConfigFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(CONFIG_FILE_PATH));
        while (scanner.hasNext()) {
            positionToSurfaceIndex.put(new Position(scanner.nextInt()), scanner.nextInt());
        }
    }
}
