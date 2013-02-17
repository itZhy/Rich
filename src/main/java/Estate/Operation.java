package Estate;

import Player.Position;
import UI.CommandLine;
import UI.Map;
import UI.UIObserver;

public class Operation {
    private final CommandLine commandLine = new CommandLine();
    private final EstateController controller = new EstateController();
    private final UIObserver ui;



    public Operation(UIObserver ui) {
        controller.initializeDefaultBuilding(ui);
        this.ui = ui;
    }

    public void handle(Position position, String name) {
        Building house = controller.get(position);
        if (house == null) {
            return;
        }
        if (checkSoldStatus(house) == false) {
            buy(position, name);
        }else{
            update(position, name);
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

}
