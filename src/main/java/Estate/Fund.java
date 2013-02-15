package Estate;



public class Fund {
    private int money;
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
}
