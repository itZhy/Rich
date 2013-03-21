package estate;

import application.GameException;

import java.util.HashMap;
import java.util.Map;

class Bank {
    private final Map<String, Fund> funds = new HashMap<String, Fund>();
    private final VipManager vipManager = new VipManager();
    private int initialFund = 10000;

    public void reset(Integer fund) {
        if (fund < 1000 || fund > 50000) throw new GameException("输入金额有误。", GameException.NEED_RETRY);
        initialFund = fund;
    }

    public String query(String account) {
        initializeWhenNotExist(account);
        return "\n资金： " + funds.get(account).toString() + "元\n";
    }

    public void withdraw(String account, Integer money) {
        initializeWhenNotExist(account);
        funds.get(account).reduce(money);
        checkBankrupt(account);
    }

    public boolean isVip(String account) {
        return vipManager.isVip(account);
    }

    public void setVip(String role) {
        vipManager.setVip(role);
    }

    public void pass(String role) {
        vipManager.pass(role);
    }

    public void add(String account, Integer money) {
        initializeWhenNotExist(account);
        funds.get(account).add(money);
    }

    public boolean checkPurchasingPower(String account, Integer price) {
        initializeWhenNotExist(account);
        return funds.get(account).isGreaterOrEqualThan(price);
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                funds.equals(((Bank) object).funds);
    }

    private void initializeWhenNotExist(String account) {
        if (!funds.containsKey(account)) {
            funds.put(account, new Fund(initialFund));
        }
    }

    private void checkBankrupt(String account) {
        if (!funds.get(account).isGreaterOrEqualThan(0)) {
            throw new Insolvency(account);
        }
    }
}
