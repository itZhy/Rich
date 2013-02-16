package Estate;

import Player.Role;
import Player.Position;
import UI.Observer;
import UI.UIException;
import Util.MapParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Operation {

    private final Map<Position, Building> buildings = new HashMap<Position, Building>();

    public Operation(Observer ui) {
        initializeDefaultBuilding(ui);
    }

    public void handle(Role role) {
    }

    private void initializeDefaultBuilding(Observer ui) {
        try {
            readDefaultBuilding(ui);
        } catch (FileNotFoundException e) {
            throw new UIException(e.toString());
        }
    }

    private void readDefaultBuilding(Observer ui) throws FileNotFoundException {
        List<Position> positions = new MapParser().readDefaultBuilding();
        for (int index = 0; index != positions.size(); ++index) {
            buildings.put(positions.get(index), new Vacancy(null, ui));
        }
    }
}
