package estate;

import application.GameException;
import player.Role;

import java.util.HashMap;
import java.util.Map;

class Bank {
    private final Map<Role, Fund> funds = new HashMap<Role, Fund>();
    private final MascotManager mascotManager = new MascotManager();
    private int initialFund = 10000;

    public void reset(Integer fund) {
        if (fund < 1000 || fund > 50000) throw new GameException("输入金额有误。", GameException.NEED_RETRY);
        initialFund = fund;
    }

    public String query(Role role) {
        initializeWhenNotExist(role);
        return "\n资金： " + funds.get(role).toString() + "元\n";
    }

    public void withdraw(Role role, Integer money) {
        initializeWhenNotExist(role);
        funds.get(role).reduce(money);
        checkBankrupt(role);
    }

    public boolean isVip(Role role) {
        return mascotManager.isVip(role);
    }

    public void setMascot(Role role) {
        mascotManager.setMascot(role);
    }

    public void updateMascot(Role role) {
        mascotManager.update(role);
    }

    public void add(Role role, Integer money) {
        initializeWhenNotExist(role);
        funds.get(role).add(money);
    }

    public boolean checkPurchasingPower(Role role, Integer price) {
        initializeWhenNotExist(role);
        return funds.get(role).isGreaterOrEqualThan(price);
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                funds.equals(((Bank) object).funds);
    }

    private void initializeWhenNotExist(Role role) {
        if (!funds.containsKey(role)) {
            funds.put(role, new Fund(initialFund));
        }
    }

    private void checkBankrupt(Role role) {
        if (!funds.get(role).isGreaterOrEqualThan(0)) {
            throw new Insolvency(role);
        }
    }
}
