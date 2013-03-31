package estate;

import player.Movement;
import player.PlayerObserver;
import player.Position;
import player.Role;
import ui.UIObserver;
import utils.Checker;

public class EstateManager implements PlayerObserver {
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
        bank.updateMascot(role);
    }

    public void sell(Position position, Role role) {
        checkIsAbleToSell(position, role);
        bank.add(role, estateMap.get(position).sellingPrice());
        estateMap.clearBuilding(position);
    }

    public void setMascot(Role role) {
        bank.setMascot(role);
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
        Checker.check(estateMap.hasBuilding(position), "该地不可买卖。");
        Checker.check(estateMap.get(position).isOwner(role), "您尚未购买该地产，请重新输入。");
    }
}
