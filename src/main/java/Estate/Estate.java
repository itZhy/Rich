package Estate;

import Player.Position;
import Player.Role;
import UI.Observer;
import org.fusesource.jansi.Ansi;

public class Estate implements BuildingObserver {
    private final Bank bank = new Bank();
    private final Operation operation;

    public Estate(Observer ui) {
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
