package Estate;

public class Sell extends Deal {
    public Sell(EstateMap estateMap, Bank bank){
        super(estateMap, bank);
    }

    public void handle(){
        bank.earnMoney(roleName, estateMap.get(position).sellingPrice());
        estateMap.clearBuilding(position);
    }
}
