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
        if (checkSoldStatus(house) == false) {
            buy(movement.currentPosition(), role);
        }else{
            update(movement.currentPosition(), role);
        }
    }

    public boolean checkSoldStatus(Building house){
        return controller.checkSoldStatus(house);
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

    public void add(String player) {
        controller.add(player);
    }

}
