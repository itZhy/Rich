package Estate;

import Player.Feature;
import Player.Position;
import UI.Element;
import UI.UIObserver;
import org.fusesource.jansi.Ansi;

public class Hovel extends Building {
    public Hovel(String role, UIObserver ui, Integer price){
        super(role, ui);
        this.price = price;
        degree = 1;
    }

    public Building update(String owner) {
        return new Villa(this.owner, ui, price);
    }

    public Integer toll(){
        return price;
    }

    public void updateUI(Position position) {
        ui.replace(position,new Feature().dye(owner, '0'), new Feature().dye(owner, '1'));
    }

    public void clear(Position position) {
        ui.replace(position, new Feature().dye(owner, '1'), new Element('0', Ansi.Color.WHITE));
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                owner.equals(((Hovel) object).owner) &&
                ui.equals(((Hovel) object).ui);
    }
}
