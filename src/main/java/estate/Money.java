package estate;

import utils.Checker;

public class Money {
    private final Double money;

    public Money(Double initialMoney) {
        money = initialMoney;
    }

    public Money add(Money addMoney) {
        return new Money(money + addMoney.money);
    }

    public Money reduce(Money reduceMoney) {
        return new Money(money - reduceMoney.money);
    }

    public Money multiply(Double factor) {
        return new Money(money * factor);
    }

    public String toString() {
        return money.toString();
    }

    public boolean isGreaterOrEqualThan(Money price) {
        return price.money <= money;
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                ((Money) object).money.equals(money);
    }

    public void checkInitialValue() {
        Checker.check(money >= 1000 && money <= 50000, "输入金额有误。");
    }
}
