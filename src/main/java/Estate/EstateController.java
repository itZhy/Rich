package Estate;

import Player.Position;
import UI.UIObserver;

public class EstateController {
    private final EstateMap estateMap = new EstateMap();
    private final Bank bank = new Bank();

    public EstateController(UIObserver ui){
        estateMap.initializeDefaultBuilding(ui);
    }

    public Building get(Position position) {
        return estateMap.get(position);
    }

    public void buy(Position position, String name) {
        estateMap.buy(position, name);
        bank.withdrawMoney(get(position).owner, get(position).price);
    }

    public boolean checkSoldStatus(Building house) {
        if (house.getClass() == Vacancy.class) {
            return false;
        }
        return true;
    }

    public boolean checkOwner(String player, Building house) {
        if (house.owner == player) {
            return true;
        }
        return false;
    }

    public boolean checkPurchasingPower(Building house) {
        return true;
    }

    public void update(Building house, Position position, String name) {
    }

    public boolean equals(Object object) {
        return Estate.class == object.getClass() &&
                bank.equals(((EstateController) object).bank);
    }



}
