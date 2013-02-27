package Estate;

import Player.Position;
import UI.PositionExtractor;
import UI.UIObserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EstateMap {
    private final Map<Position, Building> buildings = new HashMap<Position, Building>();
    private final UIObserver ui;

    public EstateMap(UIObserver ui) {
        initializeDefaultBuilding(ui);
        this.ui = ui;
    }

    public Building get(Position position) {
        return buildings.get(position);
    }

    public void update(Position position, String role) {
        buildings.put(position, get(position).update(role));
        get(position).updateUI(position);
    }

    public void clearBuilding(Position position) {
        Integer price = get(position).price;
        get(position).clear(position);
        buildings.put(position, new Vacancy(null, ui, price));
        ui.refresh();
    }

    public void clearBuildings(String role) {
        for (Map.Entry<Position, Building> house : buildings.entrySet()) {
            if (role.equals(house.getValue().owner)) clearBuilding(house.getKey());
        }
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                buildings.equals(((EstateMap) object).buildings);
    }

    public String query(String role) {
        return "地产：空地" + inquiryBuilding(role, SoldVacancy.class.toString()).size() + "处；茅屋" +
                inquiryBuilding(role, Hovel.class.toString()).size() + "处；洋房" +
                inquiryBuilding(role, Villa.class.toString()).size() + "处；摩天楼" +
                inquiryBuilding(role, Skyscraper.class.toString()).size() + "处";
    }

    private List<Building> inquiryBuilding(String role, String type) {
        List<Building> selector = new ArrayList<Building>();
        for (Building house : buildings.values()) {
            if (house.matchOwnerAndType(role, type)) selector.add(house);
        }
        return selector;
    }

    private void initializeDefaultBuilding(UIObserver ui) {
        List<Position> positions = new PositionExtractor().getBuildings();
        for(Position position: positions){
            buildings.put(position, new Vacancy(null, ui, new PriceExtractor().positionToPrice(position)));
        }
    }
}
