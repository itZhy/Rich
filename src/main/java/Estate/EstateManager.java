package Estate;

import Application.GameException;
import Player.Movement;
import Player.Observer;
import Player.Position;
import UI.UIObserver;

public class EstateManager implements Observer {
    private final EstateMap estateMap;
    private final Bank bank = new Bank();
    private final DealFactory dealFactory;

    public EstateManager(UIObserver ui) {
        estateMap = new EstateMap(ui);
        dealFactory = new DealFactory(estateMap, bank);
    }

    public void handle(String role, Movement movement) {
        if (estateMap.hasBuilding(movement.currentPosition())) {
            dealFactory.get(movement.currentPosition(), role).handle(movement.currentPosition(), role);
        }
    }

    public void sell(Position position, String role) {
        if (!estateMap.hasBuilding(position)) {
            throw new GameException("该地不可买卖。");
        }
        if (!estateMap.get(position).isOwner(role)) {
            throw new GameException("您尚未购买该地产，请重新输入。");
        }
        bank.add(role, estateMap.get(position).sellingPrice());
        estateMap.clearBuilding(position);
    }

    public void setVip(String role) {
        bank.setVip(role);
    }

    public void earnMoney(String account, Integer money) {
        bank.add(account, money);
    }

    public void setInitialFund(Integer initialFund) {
        bank.reset(initialFund);
    }

    public void goBankrupt(String role) {
        estateMap.clearBuildingsOfOwner(role);
    }

    public String query(String role) {
        return bank.query(role) + estateMap.query(role);
    }
}
