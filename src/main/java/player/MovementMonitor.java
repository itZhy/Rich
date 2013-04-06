package player;

import ui.UIObserver;

public class MovementMonitor implements PlayerObserver {
    private final UIObserver ui;

    public MovementMonitor(UIObserver ui) {
        this.ui = ui;
    }

    public void handle(Role role, Movement movement) {
        if (movement.isLeaved()) {
            ui.delete(movement.previousPosition(), role.getDisplayElement());
            return;
        }
        move(role, movement);
    }

    private void move(Role role, Movement movement) {
        ui.move(movement.previousPosition(), movement.currentPosition(), role.getDisplayElement());
        ui.refresh();
    }
}
