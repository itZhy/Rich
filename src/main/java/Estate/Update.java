package Estate;

public class Update extends Deal {
    public Update(EstateMap estateMap, Bank bank) {
        super(estateMap, bank);
    }

    public void handle() {
        if (checkChoice("升级")) {
            estateMap.update(position, roleName);
            bank.withdraw(estateMap.get(position).owner, estateMap.get(position).price);
        }
    }
}
