package Player;

import UI.UIObserver;

public class Monitor implements Observer {
    private final UIObserver ui;

    public Monitor(UIObserver ui) {
        this.ui = ui;
    }

    public void handle(String roleName, Movement movement) {
        ui.move(movement.previousPosition(), movement.currentPosition(), new Feature().get(roleName));
    }
}
