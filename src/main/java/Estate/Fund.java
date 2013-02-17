package Estate;



public class Fund {
    private Integer money;
    public Fund(Integer initialMoney) {
        money = initialMoney;
    }

    public void add(Integer addMoney){
        money += addMoney;
    }

    public void reduce(Integer reduceMoney){
        money -= reduceMoney;
    }

    public int get(){
        return money;
    }

    public boolean equals(Object object) {
        return Fund.class == object.getClass() &&
                ((Fund) object).money == money;
    }
}
