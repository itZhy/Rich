package Estate;


import UI.UIException;
import com.sun.javafx.tk.quantum.ViewPainter;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private final Map<String, Fund> funds = new HashMap<String, Fund>();
    private int initialFund = 10000;
    private VipManager vipManager = new VipManager();

    public void reset(Integer fund) {
        if (fund < 1000 || fund > 50000) {
            throw new UIException("输入金额有误。");
        }
        initialFund = fund;
    }

    public Integer inquiryAccount(String account) {
        initializeWhenNotExist(account);
        return funds.get(account).get();
    }

    public void withdrawMoney(String account, Integer money) {
        initializeWhenNotExist(account);
        if (!vipManager.vipStatus(account)) {
            funds.get(account).reduce(money);
            checkBreakAccount(account);
        }
    }

    public void checkBreakAccount(String account){
        if(inquiryAccount(account) <= 0){
            throw new InsolvencyNotify(account);
        }
    }

    public void earnMoney(String account, Integer money) {
        initializeWhenNotExist(account);
        funds.get(account).add(money);
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

    public void setVip(String role) {
        vipManager.setVip(role);
    }
}
