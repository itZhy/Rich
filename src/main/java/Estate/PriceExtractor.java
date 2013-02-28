package Estate;

import Player.Position;
import UI.PositionExtractor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PriceExtractor {
    private final Map<Position, Integer> prices = new HashMap<Position, Integer>();

    public PriceExtractor() {
        initializePrices(new PositionExtractor().getBuildings());
    }

    public Integer priceOfPosition(Position position) {
        return prices.get(position);
    }

    private void initializePrices(List<Position> positions) {
        setPriceOfTop(positions);
        setPriceOfLeft(positions);
        setPriceOfBottom(positions);
    }

    private void setPriceOfTop(List<Position> positions) {
        for (int index = 0; index != 26; ++index) {
            prices.put(positions.get(index), 200);
        }
    }

    private void setPriceOfLeft(List<Position> positions) {
        for (int index = 26; index != 32; ++index) {
            prices.put(positions.get(index), 500);
        }
    }

    private void setPriceOfBottom(List<Position> positions) {
        for (int index = 32; index != 58; ++index) {
            prices.put(positions.get(index), 300);
        }
    }
}
