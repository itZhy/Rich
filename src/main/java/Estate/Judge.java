package Estate;

import Player.Position;

public class Judge {
    private final EstateMap estateMap;
    private final Bank bank;

    public Judge(EstateMap estateMap, Bank bank) {
        this.estateMap = estateMap;
        this.bank = bank;
    }

    public boolean isMetToBuy(Position position, String role) {
        return (!checkSoldStatus(position)) && checkPurchasingPower(position, role);
    }

    public boolean isMetToPay(Position position, String role) {
        return (checkSoldStatus(position)) && !checkOwner(position, role);
    }

    public boolean isMetToUpdate(Position position, String role) {
        return (checkSoldStatus(position)) && checkPurchasingPower(position, role) && checkEnableUpdate(position);
    }

    public boolean checkOwner(Position position, String roleName) {
        return roleName.equals(estateMap.get(position).owner);
    }

    private boolean checkSoldStatus(Position position) {
        return (estateMap.get(position).getClass() != Vacancy.class);
    }

    private boolean checkPurchasingPower(Position position, String role) {
        return bank.checkPurchasingPower(role, estateMap.get(position).basePrice);
    }

    private boolean checkEnableUpdate(Position position) {
        return (estateMap.get(position).getClass() != Skyscraper.class);
    }
}
