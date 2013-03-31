package estate;

import player.Position;
import player.Role;

class Judge {
    private final EstateMap estateMap;
    private final Bank bank;

    public Judge(EstateMap estateMap, Bank bank) {
        this.estateMap = estateMap;
        this.bank = bank;
    }

    public boolean isMetToBuy(Position position, Role role) {
        return (!isSold(position)) && canAfford(position, role);
    }

    public boolean isMetToPay(Position position, Role role) {
        return (isSold(position)) && isNotOwner(position, role);
    }

    public boolean isMetToUpdate(Position position, Role role) {
        return (isSold(position)) && canAfford(position, role) && isUpdateToTop(position);
    }

    private boolean isNotOwner(Position position, Role role) {
        return !estateMap.get(position).isOwner(role);
    }

    private boolean isSold(Position position) {
        return (estateMap.get(position).getClass() != Vacancy.class);
    }

    private boolean canAfford(Position position, Role role) {
        return bank.checkPurchasingPower(role, estateMap.get(position).basePrice);
    }

    private boolean isUpdateToTop(Position position) {
        return (estateMap.get(position).getClass() != Skyscraper.class);
    }
}
