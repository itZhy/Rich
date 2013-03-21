package estate;

import application.GameException;
import player.Role;
import player.Movement;
import player.Observer;
import player.Position;
import ui.UIObserver;

public class EstateManager implements Observer {
    private final EstateMap estateMap;
    private final Bank bank = new Bank();
    private final DealFactory dealFactory;

    public EstateManager(UIObserver ui) {
        estateMap = new EstateMap(ui);
        dealFactory = new DealFactory(estateMap, bank);
    }

    public void handle(Role role, Movement movement) {
        if (estateMap.hasBuilding(movement.currentPosition())) {
            dealFactory.get(movement.currentPosition(), role).handle(movement.currentPosition(), role);
        }
        bank.pass(role);
    }

    public void sell(Position position, Role role) {
        checkIsAbleToSell(position, role);
        bank.add(role, estateMap.get(position).sellingPrice());
        estateMap.clearBuilding(position);
    }

    public void setVip(Role role) {
        bank.setVip(role);
    }

    public void bonus(Role account) {
        bank.add(account, 2000);
    }

    public void setInitialFund(Integer initialFund) {
        bank.reset(initialFund);
    }

    public void goBankrupt(Role role) {
        estateMap.clearBuildingsOfOwner(role);
    }

    public String query(Role role) {
        return bank.query(role) + estateMap.query(role);
    }

    private void checkIsAbleToSell(Position position, Role role) {
        if (!estateMap.hasBuilding(position)) {
            throw new GameException("该地不可买卖。", GameException.NEED_RETRY);
        }
        if (!estateMap.get(position).isOwner(role)) {
            throw new GameException("您尚未购买该地产，请重新输入。", GameException.NEED_RETRY);
        }
    }
}
