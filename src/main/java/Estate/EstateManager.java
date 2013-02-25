package Estate;

import Application.GameException;
import Player.Movement;
import Player.Observer;
import Player.Position;
import UI.CommandLine;
import UI.UIObserver;

public class EstateManager implements Observer {
    private final CommandLine commandLine = new CommandLine();
    private final EstateController controller;
    private final UIObserver ui;

    public EstateManager(UIObserver ui) {
        controller = new EstateController(ui);
        this.ui = ui;
    }

    public void handle(String role, Movement movement) {
        if (!(controller.get(movement.currentPosition()) == null)) {
            handleBusiness(movement.currentPosition(), role);
        }
    }

    private void handleBusiness(Position position, String role) {
        if (!controller.checkSoldStatus(position)) {
            buy(position, role);
        } else {
            handlePurchaseBusiness(position, role);
        }
    }

    private void handlePurchaseBusiness(Position position, String role) {
        if (!controller.checkOwner(role, controller.get(position))) {
            payRent(position, role);
        } else {
            update(position, role);
        }
    }

    private void payRent(Position position, String role) {
        commandLine.waitForInput("路过他人地产，留下买路钱(>_<)");
        controller.payRent(position, role);
    }

    public void sell(Position position, String role) {
        if (controller.get(position) == null || !controller.checkOwner(role, controller.get(position))) {
            throw new GameException("您尚未购买该地产，请重新输入。");
        }
        controller.sell(position, role);
        ui.refresh();
    }

    public void update(Position position, String role) {
        if (controller.checkPurchasingPower(role, controller.get(position)) && controller.checkEnableUpdate(position)) {
            if ("Y".equals(commandLine.waitForInput("是否花费" + controller.get(position).price + "元升级该地产？"))) {
                controller.update(position, role);
            }
        }
    }

    public void buy(Position position, String role) {
        if (controller.checkPurchasingPower(role, controller.get(position))) {
            if ("Y".equals(commandLine.waitForInput("是否花费" + controller.get(position).price + "元购买该地产？"))) {
                controller.buy(position, role);
            }
        }
    }

    public void setVip(String role) {
        controller.setVip(role);
    }

    public void setInitialFund(Integer initialFund) {
        controller.setInitialFund(initialFund);
    }

    public void goBankrupt(String role) {
        controller.clearBuildings(role);
    }
}
