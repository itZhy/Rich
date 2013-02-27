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
        return (checkSoldStatus(position)) && checkPurchasingPower(position, role) && isUpdateToTop(position);
    }

    public boolean checkOwner(Position position, String roleName) {
        return estateMap.get(position).isOwner(roleName);
    }

    private boolean checkSoldStatus(Position position) {
        return (estateMap.get(position).getClass() != Vacancy.class);
    }

    private boolean checkPurchasingPower(Position position, String role) {
        return bank.checkPurchasingPower(role, estateMap.get(position).basePrice);
    }

    private boolean isUpdateToTop(Position position) {
        return (estateMap.get(position).getClass() != Skyscraper.class);
    }
}
