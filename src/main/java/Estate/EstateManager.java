package Estate;

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
        dealFactory.get(movement.currentPosition(), role).handle();
    }

    public void sell(Position position, String role) {
        dealFactory.sell(position, role).handle();
    }

    public void setVip(String role) {
        bank.setVip(role);
    }

    public void earnMoney(String account, Integer money) {
        bank.earnMoney(account, money);
    }

    public void setInitialFund(Integer initialFund) {
        bank.reset(initialFund);
    }

    public void goBankrupt(String role) {
        estateMap.clearBuildings(role);
    }

    public String query(String role) {
        return "\n资金： " + bank.inquiryAccount(role) + "元\n" + estateMap.inquiryAccount(role);
    }
}
