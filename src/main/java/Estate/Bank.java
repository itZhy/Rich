package Estate;


import java.util.HashMap;
import java.util.Map;

public class Bank {
    private final Map<String, Fund> funds = new HashMap<String, Fund>();
    private int initialFund = 10000;

    public void reset(int fund) {
        initialFund = fund;
    }

    public void withdrawMoney(String account, Integer money) {
        initializeWhenNotExist(account);
        funds.get(account).reduce(money);
    }

    private void initializeWhenNotExist(String account) {
        if (!funds.containsKey(account)) {
            funds.put(account, new Fund(initialFund));
        }
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                funds.equals(((Bank) object).funds);
    }

    public boolean checkPurchasingPower(String account, Integer price) {
        initializeWhenNotExist(account);
        return funds.get(account).compare(price);
    }
}
