package Player;

import UI.UIObserver;

public class MovementMonitor implements Observer {
    private final UIObserver ui;

    public MovementMonitor(UIObserver ui) {
        this.ui = ui;
    }

    public void handle(String roleName, Movement movement) {
        ui.move(movement.previousPosition(), movement.currentPosition(), new Feature().get(roleName));
        ui.refresh();
    }
}
