package Player;

import UI.UIObserver;

public class RoleMonitor implements Observer {
    private final UIObserver ui;

    public RoleMonitor(UIObserver ui) {
        this.ui = ui;
    }

    public void handle(String roleName, Movement movement) {
        ui.move(movement.previousPosition(), movement.currentPosition(), new Feature().get(roleName));
    }
}
