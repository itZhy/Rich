package Estate;

import Application.GameException;
import Player.Position;

public class DealFactory {
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
        return new DoNothing(estateMap, bank);
    }

    public Deal sell(Position position, String role) {
        if (!judge.checkOwner(position, role)) {
            throw new GameException("您尚未购买该地产，请重新输入。");
        }
        return new Sell(estateMap, bank);
    }
}
