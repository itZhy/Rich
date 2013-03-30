package estate;

import player.Position;
import player.Role;
import ui.PositionExtractor;
import ui.UIObserver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class EstateMap {
    private final Map<Position, Building> buildings = new HashMap<Position, Building>();
    private final UIObserver ui;

    public EstateMap(UIObserver ui) {
        this.ui = ui;
        initializeDefaultBuilding();
    }

    public Building get(Position position) {
        return buildings.get(position);
    }

    public void update(Position position, Role role) {
        buildings.put(position, get(position).update(role));
        get(position).updateUI(position, ui);
        ui.refresh();
    }

    public void clearBuilding(Position position) {
        get(position).clearUI(position, ui);
        buildings.put(position, new Vacancy(new PriceExtractor().priceOfPosition(position)));
        ui.refresh();
    }

    public void clearBuildingsOfOwner(Role role) {
        for (Map.Entry<Position, Building> house : buildings.entrySet()) {
            if (house.getValue().isOwner(role)) {
                clearBuilding(house.getKey());
            }
        }
    }

    public String query(Role role) {
        return "地产：空地" + inquiryBuilding(role, SoldVacancy.class) + "处；茅屋" +
                inquiryBuilding(role, Hovel.class) + "处；洋房" +
                inquiryBuilding(role, Villa.class) + "处；摩天楼" +
                inquiryBuilding(role, Skyscraper.class) + "处";
    }

    public boolean hasBuilding(Position position) {
        return buildings.containsKey(position);
    }

    private int inquiryBuilding(Role role, Class type) {
        int count = 0;
        for (Building house : buildings.values()) {
            if (house.matchOwnerAndType(role, type)) {
                ++count;
            }
        }
        return count;
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                buildings.equals(((EstateMap) object).buildings);
    }

    private void initializeDefaultBuilding() {
        List<Position> positions = new PositionExtractor().getBuildings();
        for (Position position : positions) {
            buildings.put(position, new Vacancy(new PriceExtractor().priceOfPosition(position)));
        }
    }
}
