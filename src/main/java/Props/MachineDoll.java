package Props;

import Player.Position;
import Player.Role;
import UI.UIObserver;

public class MachineDoll extends Prop {
    private final PropsMap propsMap;

    public MachineDoll(PropsMap propsMap) {
        this.propsMap = propsMap;
        price = 30;
    }

    public void handle(Position position, Role role) {
        propsMap.cleanTheFront(position);
    }

    public void addToUI(UIObserver ui, Position position) {
    }

    public void removeFromUI(UIObserver ui, Position position) {
    }
}