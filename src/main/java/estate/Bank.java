package estate;

import player.Role;

import java.util.HashMap;
import java.util.Map;

class Bank {
    private final Map<Role, Money> funds = new HashMap<Role, Money>();
    private final MascotManager mascotManager = new MascotManager();
    private Money initialMoney = new Money(10000.);

    public void reset(Money money) {
        money.checkInitialValue();
        initialMoney = money;
    }

    public String query(Role role) {
        initializeWhenNotExist(role);
        return "\n资金： " + funds.get(role) + "元\n";
    }

    public void withdraw(Role role, Money money) {
        initializeWhenNotExist(role);
        funds.put(role, funds.get(role).reduce(money));
        checkBankrupt(role);
    }

    public boolean hasMascot(Role role) {
        return mascotManager.hasMascot(role);
    }

    public void setMascot(Role role) {
        mascotManager.setMascot(role);
    }

    public void updateMascot(Role role) {
        mascotManager.update(role);
    }

    public void add(Role role, Money money) {
        initializeWhenNotExist(role);
        funds.put(role, funds.get(role).add(money));
    }

    public boolean checkPurchasingPower(Role role, Money price) {
        initializeWhenNotExist(role);
        return funds.get(role).isGreaterOrEqualThan(price);
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                funds.equals(((Bank) object).funds);
    }

    private void initializeWhenNotExist(Role role) {
        if (!funds.containsKey(role)) {
            funds.put(role, initialMoney);
        }
    }

    private void checkBankrupt(Role role) {
        if (!funds.get(role).isGreaterOrEqualThan(new Money(0.))) {
            throw new Insolvency(role);
        }
    }
}
