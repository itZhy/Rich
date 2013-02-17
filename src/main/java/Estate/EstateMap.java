package Estate;

import Player.Position;
import UI.PositionExtractor;
import UI.PositionExtractor;
import UI.UIException;
import UI.UIObserver;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EstateMap {
    private final Map<Position, Building> buildings = new HashMap<Position, Building>();

    public Building get(Position position) {
        return buildings.get(position);
    }

    public void update(Building house, Position position, String name) {
    }

    public void buy(Position position, String name) {
        buildings.put(position, get(position).update(name));
        get(position).updateUI(position);
    }

    public boolean checkSoldStatus(Building house) {
        if (house.getClass() == Vacancy.class) {
            return false;
        }
        return true;
    }

    public void initializeDefaultBuilding(UIObserver ui) {
        try {
            readDefaultBuilding(ui);
        } catch (FileNotFoundException e) {
            throw new UIException(e.toString());
        }
    }

    private void readDefaultBuilding(UIObserver ui) throws FileNotFoundException {
        List<Position> positions = new PositionExtractor().getBuildings();
        for (int index = 0; index != positions.size(); ++index) {
            buildings.put(positions.get(index), new Vacancy(null, ui));
        }
        markDefaultPrice(positions);
    }

    private void markDefaultPrice(List<Position> positions) {
        List<Integer> prices = new ArrayList<Integer>() {{
            add(200);
            add(500);
            add(300);
        }};
        int counter = 0;
        for (int i = 0; i != prices.size(); ++i) {
            int size = (i == 1) ? 6 : 26;
            for (int index = 0; index != size; ++index) {
                buildings.get(positions.get(counter++)).markPrice(prices.get(i));
            }
        }
    }
}
