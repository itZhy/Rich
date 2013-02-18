package Estate;

import Player.Movement;
import Player.Observer;
import Player.Position;
import UI.CommandLine;
import UI.UIException;
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
        if (!controller.checkSoldStatus(house)) {
            buy(movement.currentPosition(), role);
            return;
        }
        if (!controller.checkOwner(role, house)) {
            payRent(movement.currentPosition(), role);
        } else {
            update(movement.currentPosition(), role);
        }
    }

    private boolean checkPurchasingPower(String role, Building house) {
        return controller.checkPurchasingPower(role, house);
    }

    private boolean checkEnableUpdate(Position position) {
        return controller.checkEnableUpdate(position);
    }

    private void payRent(Position position, String role) {
        ui.refresh();
        commandLine.showMessageInNewline("路过他人地产，留下买路钱(>_<)");
        controller.payRent(position, role);
    }

    public void sell(Position position, String role){
        if (!controller.checkOwner(role, controller.get(position))) {
            throw new UIException("您尚未购买该地产，请重新输入。");
        }
        controller.sell(position, role);
    }

    public void update(Position position, String role) {
        ui.refresh();
        if (checkPurchasingPower(role, controller.get(position)) && checkEnableUpdate(position)) {
            commandLine.showMessageInNewline(
                    "是否花费" + controller.get(position).price + "元升级该地产？");
            if ("Y".equals(commandLine.waitForInput())) {
                controller.update(position, role);
            }
        }
    }

    public void buy(Position position, String role) {
        ui.refresh();
        if (checkPurchasingPower(role, controller.get(position))) {
            commandLine.showMessageInNewline(
                    "是否花费" + controller.get(position).price + "元购买该地产？");
            if ("Y".equals(commandLine.waitForInput())) {
                controller.buy(position, role);
            }
        }
    }

    public void setMascot() {

    }

}
