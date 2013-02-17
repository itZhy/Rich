package Estate;

import Player.Position;
import UI.UIObserver;
import UI.UIException;
import Util.MapParser;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Operation {

    private final Map<Position, Building> buildings = new HashMap<Position, Building>();

    public Operation(UIObserver ui) {
        initializeDefaultBuilding(ui);
    }

    public void handle(Position position, String name) {
        Building house = buildings.get(position);

        if (house == null) {
            return;
        }
        if (checkSoldStatus(house) == false) {
            buy(house, name);
        }
    }

    private Building buy(Building house, String name) {
        return house.update(name);
    }

    public boolean checkSoldStatus(Building house) {
        if (house.getClass() == Vacancy.class) {
            return false;
        }
        return true;
    }

    private void initializeDefaultBuilding(UIObserver ui) {
        try {
            readDefaultBuilding(ui);
        } catch (FileNotFoundException e) {
            throw new UIException(e.toString());
        }
    }

    private void readDefaultBuilding(UIObserver ui) throws FileNotFoundException {
        List<Position> positions = new MapParser().readDefaultBuilding();
        for (int index = 0; index != positions.size(); ++index) {
            buildings.put(positions.get(index), new Vacancy(null, ui));
        }
    }
}
