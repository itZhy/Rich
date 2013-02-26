package Estate;

import UI.CommandLine;

public class NullDeal extends Deal {
    public NullDeal(EstateMap estateMap, Bank bank){
        super(estateMap, bank);
    }

    public void handle(){
    }
}
