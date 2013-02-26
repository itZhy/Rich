package Estate;

import UI.CommandLine;

public class Buy extends Deal {
    public Buy(EstateMap estateMap, Bank bank){
        super(estateMap, bank);
    }

    public void handle(){
        if(checkChoice("购买")){
            estateMap.update(position, roleName);
            bank.withdraw(roleName, estateMap.get(position).price);
        }
    }
}
