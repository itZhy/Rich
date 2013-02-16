package Props;

import Player.Position;
import Player.Role;
import UI.UIObserver;

public class MachineDoll extends Prop {
    private final PropsMap propsMap;
    public MachineDoll(UIObserver ui, PropsMap propsMap) {
        super(ui);
        this.propsMap = propsMap;
        price = 30;
    }

    public void handle(Position position, Role role) {
        propsMap.cleanTheFront(position);
    }

    public void addToUI(Position position) {
    }

    public void removeFromUI(Position position) {
    }
}