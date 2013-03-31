package estate;

import player.Position;
import ui.PositionExtractor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PriceExtractor {
    private final Map<Position, Money> prices = new HashMap<Position, Money>();

    public PriceExtractor() {
        initializePrices(new PositionExtractor().getBuildings());
    }

    public Money priceOfPosition(Position position) {
        return prices.get(position);
    }

    private void initializePrices(List<Position> positions) {
        setPriceOfTop(positions);
        setPriceOfLeft(positions);
        setPriceOfBottom(positions);
    }

    private void setPriceOfTop(List<Position> positions) {
        for (int index = 0; index != 26; ++index) {
            prices.put(positions.get(index), new Money(200.));
        }
    }

    private void setPriceOfLeft(List<Position> positions) {
        for (int index = 26; index != 32; ++index) {
            prices.put(positions.get(index), new Money(500.));
        }
    }

    private void setPriceOfBottom(List<Position> positions) {
        for (int index = 32; index != 58; ++index) {
            prices.put(positions.get(index), new Money(300.));
        }
    }
}
