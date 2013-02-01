package UI;

import Player.Position;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Converter {
    private final String CONFIG_FILE_PATH = "position_to_surface_index";
    private Map<Position, Integer> positionToSurfaceIndex = new HashMap<Position, Integer>();

    public Converter() {
        initializePositionToSurfaceIndex();
    }

    public int convert(Position position) {
        if (null == positionToSurfaceIndex.get(position)) {
            throw new UIException("The content in " + CONFIG_FILE_PATH + " is not correct.");
        }

        return positionToSurfaceIndex.get(position);
    }

    private void initializePositionToSurfaceIndex() {
        try {
            readConfigFile();
        } catch (FileNotFoundException e) {
            throw new UIException(e.toString());
        }
    }

    private void readConfigFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(CONFIG_FILE_PATH));
        while (scanner.hasNext()) {
            positionToSurfaceIndex.put(new Position(scanner.nextInt()), scanner.nextInt());
        }
    }
}
