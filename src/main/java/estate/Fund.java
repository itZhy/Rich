package estate;

class Fund {
    private Integer money;

    public Fund(Integer initialMoney) {
        money = initialMoney;
    }

    public void add(Integer addMoney) {
        money += addMoney;
    }

    public void reduce(Integer reduceMoney) {
        money -= reduceMoney;
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
}
