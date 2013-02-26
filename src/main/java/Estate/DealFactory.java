package Estate;

import Application.GameException;
import Player.Position;

import java.util.HashMap;
import java.util.Map;

public class DealFactory {
    protected EstateMap estateMap;
    protected Bank bank;
    private Judge controller;
    private final Map<String, Deal> deals = new HashMap<String, Deal>();

    public DealFactory(EstateMap estateMap, Bank bank) {
        this.estateMap = estateMap;
        this.bank = bank;
        controller = new Judge(estateMap, bank);
        initializeDeals();
    }

    public Deal get(Position position, String role) {
        if (estateMap.get(position) != null) {
            if (!controller.checkSoldStatus(position)) {
                if (controller.checkPurchasingPower(role, estateMap.get(position))) {
                    return deals.get("buy").set(position, role);
                }
            } else {
                return handleBusiness(position, role);
            }
        }
        return deals.get("null");
    }

    public Deal sell(Position position, String role) {
        if (estateMap.get(position) == null || !controller.checkOwner(role, estateMap.get(position))) {
            throw new GameException("您尚未购买该地产，请重新输入。");
        }
        return deals.get("sell").set(position, role);
    }

    private Deal handleBusiness(Position position, String role) {
        if (!controller.checkOwner(role, estateMap.get(position))) {
            return deals.get("pay").set(position, role);
        } else if (controller.checkPurchasingPower(role, estateMap.get(position)) && controller.checkEnableUpdate(position)) {
            return deals.get("update").set(position, role);
        }
        return deals.get("null");
    }

    private void initializeDeals() {
        deals.put("buy", new Buy(estateMap, bank));
        deals.put("update", new Update(estateMap, bank));
        deals.put("pay", new Pay(estateMap, bank));
        deals.put("sell", new Sell(estateMap, bank));
        deals.put("null", new NullDeal(estateMap, bank));
    }
}
