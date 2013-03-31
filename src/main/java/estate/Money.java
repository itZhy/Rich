package estate;

import utils.Checker;

public class Money {
    private final Integer money;

    public Money(Integer initialMoney) {
        money = initialMoney;
    }

    public Money add(Integer addMoney) {
        return new Money(money + addMoney);
    }

    public Money reduce(Integer reduceMoney) {
        return new Money(money - reduceMoney);
    }

    public String toString() {
        return money.toString();
    }

    public boolean isGreaterOrEqualThan(Integer price) {
        return price <= money;
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                ((Money) object).money.equals(money);
    }

    public void checkInitialValue() {
        Checker.check(money >= 1000 && money <= 50000, "输入金额有误。");
    }
}
