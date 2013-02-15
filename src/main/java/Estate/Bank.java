package Estate;


import Player.Player;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private final Map<String, Fund> funds = new HashMap<String, Fund>();
    private int initialFund = 10000;

    public void reset(int fund){
        initialFund = fund;
    }

    public void add(String player){
        funds.put(player, new Fund(initialFund));
    }
}
