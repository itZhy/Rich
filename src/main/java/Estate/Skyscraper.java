package Estate;

import Player.Feature;
import Player.Position;
import UI.UIObserver;

public class Skyscraper extends Building {

    public Skyscraper(String role, UIObserver ui, Integer price){
        super(role, ui);
        this.price = price;
        degree = 3;
    }

    public Building update(String owner) {
        return null;
    }

    public Integer toll(){
        return price * 4;
    }

    public void updateUI(Position position) {
        ui.replace(position,new Feature().dye(owner, '2'), new Feature().dye(owner, '3'));
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                owner.equals(((Skyscraper) object).owner) &&
                ui.equals(((Skyscraper) object).ui);
    }
}
