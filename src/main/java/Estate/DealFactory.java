package estate;

import player.Position;

class DealFactory {
    private final Judge judge;
    private final EstateMap estateMap;
    private final Bank bank;

    public DealFactory(EstateMap estateMap, Bank bank) {
        this.estateMap = estateMap;
        this.bank = bank;
        judge = new Judge(estateMap, bank);
    }

    public Deal get(Position position, String role) {
        if (judge.isMetToBuy(position, role)) {
            return new Buy(estateMap, bank);
        }
        if (judge.isMetToPay(position, role)) {
            return new Pay(estateMap, bank);
        }
        if (judge.isMetToUpdate(position, role)) {
            return new Update(estateMap, bank);
        }
        return new Idle(estateMap, bank);
    }
}