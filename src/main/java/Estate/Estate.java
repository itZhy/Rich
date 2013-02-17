package Estate;

import Player.Movement;
import Player.Observer;
import UI.UIObserver;


public class Estate implements Observer {
    private final Bank bank = new Bank();
    private final Operation operation;

    public Estate(UIObserver ui) {
        operation = new Operation(ui);
    }

    public void handle(String role, Movement movement){
        operation.handle(movement.currentPosition(), role);
    }

    public void add(String player) {
        bank.add(player);
    }

    public boolean equals(Object object) {
        return Estate.class == object.getClass() &&
                bank.equals(((Estate) object).bank);
    }
}
