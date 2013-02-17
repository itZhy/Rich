package Estate;



public class Fund {
    private Integer money;
    public Fund(int initialMoney) {
        money = initialMoney;
    }

    public void add(int addMoney){
        money += addMoney;
    }

    public void reduce(int reduceMoney){
        money += reduceMoney;
    }

    public int get(){
        return money;
    }

    public boolean equals(Object object) {
        return Fund.class == object.getClass() &&
                ((Fund) object).money == money;
    }
}
