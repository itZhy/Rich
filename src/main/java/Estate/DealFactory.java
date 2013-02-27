package Estate;

import Application.GameException;
import Player.Position;

import java.util.HashMap;
import java.util.Map;

public class DealFactory {
    private Judge judge;
    private final Map<String, Deal> deals = new HashMap<String, Deal>();

    public DealFactory(EstateMap estateMap, Bank bank) {
        judge = new Judge(estateMap, bank);
        initializeDeals(estateMap, bank);
    }

    public Deal get(Position position, String role) {
        if (judge.hasBuilding(position)) {
            if (judge.isMetToBuy(position, role)) {
                return deals.get("buy").set(position, role);
            }
            if (judge.isMetToPay(position, role)) {
                return deals.get("pay").set(position, role);
            }
            if (judge.isMetToUpdate(position, role)) {
                return deals.get("update").set(position, role);
            }
        }
        return deals.get("null");
    }

    public Deal sell(Position position, String role) {
        if (judge.hasBuilding(position) || !judge.checkOwner(position, role)) {
            throw new GameException("您尚未购买该地产，请重新输入。");
        }
        return deals.get("sell").set(position, role);
    }

    private void initializeDeals(EstateMap estateMap, Bank bank) {
        deals.put("buy", new Buy(estateMap, bank));
        deals.put("update", new Update(estateMap, bank));
        deals.put("pay", new Pay(estateMap, bank));
        deals.put("sell", new Sell(estateMap, bank));
        deals.put("null", new NullDeal(estateMap, bank));
    }
}
