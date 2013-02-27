package Estate;

import Player.Position;
import UI.PositionExtractor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PriceExtractor {
    Map<Position, Integer> prices = new HashMap<Position, Integer>();

    public PriceExtractor(){
        markDefaultPrice(new PositionExtractor().getBuildings());
    }

    public Integer positionToPrice(Position position) {
        return prices.get(position);
    }

    private void markDefaultPrice(List<Position> positions) {
        int counter = 0;
        for (int i = 0; i != defaultPrice().size(); ++i) {
            for (int index = 0; index != ((i == 1) ? 6 : 26); ++index) {
                prices.put(positions.get(counter++), defaultPrice().get(i));
            }
        }
    }

    private List<Integer> defaultPrice() {
        return new ArrayList<Integer>() {{
            add(200);
            add(500);
            add(300);
        }};
    }
}
