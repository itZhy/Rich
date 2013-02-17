package Estate;


import java.util.HashMap;
import java.util.Map;

public class Bank {
    private final Map<String, Fund> funds = new HashMap<String, Fund>();
    private int initialFund = 10000;

    public void reset(int fund){
        initialFund = fund;
    }

    public void add(String account){
        funds.put(account, new Fund(initialFund));
    }

    public void withdrawMoney(String account, Integer money){
       funds.get(account).reduce(money);
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                funds.equals(((Bank) object).funds);
    }

}
