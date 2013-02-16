package Estate;

import Player.Position;
import UI.UIObserver;
import org.fusesource.jansi.Ansi;

public class Estate implements BuildingObserver {
    private final Bank bank = new Bank();
    private final Operation operation;

    public Estate(UIObserver ui) {
        operation = new Operation(ui);
    }

    public void handle(Position position, String name, Ansi.Color color){
        operation.handle(position, name, color);
    }

    public void add(String player) {
        bank.add(player);
    }

    public boolean equals(Object object) {
        return Estate.class == object.getClass() &&
                bank.equals(((Estate) object).bank);
    }
}
