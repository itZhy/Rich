package Estate;

import Player.Role;
import UI.Observer;

public class Estate implements BuildingObserver {
    private final Bank bank = new Bank();
    private final Operation operation;

    public Estate(Observer ui) {
        operation = new Operation(ui);
    }

    public void handle(Role role) {
        operation.handle(role);
    }

    public void add(String player) {
        bank.add(player);
    }

    public boolean equals(Object object) {
        return Estate.class == object.getClass() &&
                bank.equals(((Estate) object).bank);
    }
}
