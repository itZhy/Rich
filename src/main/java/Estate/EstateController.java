package Estate;

import Player.Position;
import UI.UIObserver;

public class EstateController {
    private final EstateMap estateMap;
    private final Bank bank = new Bank();

    public EstateController(UIObserver ui) {
        estateMap = new EstateMap(ui);
    }

    public Building get(Position position) {
        return estateMap.get(position);
    }

    public void buy(Position position, String role) {
        estateMap.buy(position, role);
        bank.withdrawMoney(role, get(position).price);
    }

    public boolean checkSoldStatus(Building house) {
        return (house.getClass() == Vacancy.class)?false:true;
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

    public void payRent(Position position, String role) {
        bank.withdrawMoney(role, get(position).toll());
        bank.earnMoney(get(position).owner, get(position).toll());
    }

    public void sell(Position position, String role) {
        estateMap.clearBuilding(position);
        bank.earnMoney(role, get(position).sellingPrice());
    }
}
