package Estate;

import Player.Role;
import UI.CommandLine;

public class Estate {
    private final CommandLine commandLine = new CommandLine();
    private final Bank bank = new Bank();
    private final Operation operation = new Operation();


    public void handle(Role role){
        operation.handle(role);
    }

    public void add(String player){
        bank.add(player);
    }

    public boolean equals(Object object) {
        return Estate.class == object.getClass() &&
                bank.equals(((Estate) object).bank);
    }
}
