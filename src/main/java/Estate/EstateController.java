package Estate;

import Player.Position;
import UI.UIObserver;

public class EstateController {
    private final EstateMap estateMap;
    private final Bank bank;

    public EstateController(EstateMap estateMap, Bank bank) {
        this.estateMap = estateMap;
        this.bank = bank;
    }

    public boolean checkSoldStatus(Position position) {
        return (estateMap.get(position).getClass() != Vacancy.class);
    }

    public boolean checkOwner(String player, Building house) {
        return player.equals(house.owner);
    }

    public boolean checkPurchasingPower(String role, Building house) {
        return bank.checkPurchasingPower(role, house.price);
    }

    public boolean equals(Object object) {
        return EstateManager.class == object.getClass() &&
                bank.equals(((EstateController) object).bank);
    }

    public boolean checkEnableUpdate(Position position) {
        return (estateMap.get(position).getClass() != Skyscraper.class);
    }
}
