package Estate;

import Player.Movement;
import Player.Observer;
import Player.Position;
import UI.CommandLine;
import UI.UIObserver;

public class Estate implements Observer {
    private final CommandLine commandLine = new CommandLine();
    private final EstateController controller;
    private final UIObserver ui;

    public Estate(UIObserver ui) {
        controller = new EstateController(ui);
        this.ui = ui;
    }

    public void handle(String role, Movement movement) {
        Building house = controller.get(movement.currentPosition());
        if (house == null) {
            return;
        }
        if (controller.checkSoldStatus(house) == false) {
            buy(movement.currentPosition(), role);
            return;
        }
        if (controller.checkOwner(role, house) == false) {
            payRent();
        } else {
            update(movement.currentPosition(), role);
        }
    }

    private void payRent() {
    }

    public boolean checkPurchasingPower(String role, Building house) {
        return controller.checkPurchasingPower(role, house);
    }

    public void update(Position position, String name) {
    }

    public void buy(Position position, String name) {
        ui.refresh();
        commandLine.showPromptMessageInNewline(
                "是否花费" + controller.get(position).price + "元购买该地产？");
        if ("Y".equals(commandLine.waitForInput())) {
            controller.buy(position, name);
        }
    }

}
