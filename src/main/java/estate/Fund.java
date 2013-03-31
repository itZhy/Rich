package estate;

import utils.Checker;

public class Fund {
    private final Integer money;

    public Fund(Integer initialMoney) {
        money = initialMoney;
    }

    public Fund add(Integer addMoney) {
        return new Fund(money + addMoney);
    }

    public Fund reduce(Integer reduceMoney) {
        return new Fund(money - reduceMoney);
    }

    public String toString() {
        return money.toString();
    }

    public boolean isGreaterOrEqualThan(Integer price) {
        return (price <= money);
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                ((Fund) object).money.equals(money);
    }

    public void checkInitialValue() {
        Checker.check(money >= 1000 && money <= 50000, "输入金额有误。");
    }
}
