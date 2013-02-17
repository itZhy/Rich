package Estate;

import Player.Position;
import UI.UIObserver;


public class Estate implements EstateObserver {
    private final Bank bank = new Bank();
    private final Operation operation;

    public Estate(UIObserver ui) {
        operation = new Operation(ui);
    }

    public void handle(Position position, String name){
        operation.handle(position, name);
    }

    public void add(String player) {
        bank.add(player);
    }

    public boolean equals(Object object) {
        return Estate.class == object.getClass() &&
                bank.equals(((Estate) object).bank);
    }
}
