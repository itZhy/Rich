package Estate;

import Player.Position;
import UI.UIObserver;

public class EstateController {
    private final EstateMap estateMap = new EstateMap();
    private final Bank bank = new Bank();

    public EstateController(UIObserver ui) {
        estateMap.initializeDefaultBuilding(ui);
    }

    public Building get(Position position) {
        return estateMap.get(position);
    }

    public void buy(Position position, String role) {
        estateMap.buy(position, role);
        bank.withdrawMoney(get(position).owner, get(position).price);
    }

    public boolean checkSoldStatus(Building house) {
        if (house.getClass() == Vacancy.class) {
            return false;
        }
        return true;
    }

    public boolean checkOwner(String player, Building house) {
        return house.owner.equals(player);
    }

    public boolean checkPurchasingPower(String role, Building house) {
        return bank.checkPurchasingPower(role, house.price);
    }

    public void update(Position position, String role) {
        estateMap.update(position, role);
        bank.withdrawMoney(get(position).owner, get(position).price);
    }

    public boolean equals(Object object) {
        return Estate.class == object.getClass() &&
                bank.equals(((EstateController) object).bank);
    }


    public boolean checkEnableUpdate(Position position) {
        return (get(position).getClass() == Skyscraper.class) ? false : true;
    }
}
