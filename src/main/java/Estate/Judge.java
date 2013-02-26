package Estate;

import Player.Position;

public class Judge {
    private final EstateMap estateMap;
    private final Bank bank;

    public Judge(EstateMap estateMap, Bank bank) {
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
        return getClass() == object.getClass() &&
                bank.equals(((Judge) object).bank);
    }

    public boolean checkEnableUpdate(Position position) {
        return (estateMap.get(position).getClass() != Skyscraper.class);
    }
}
