package Estate;

import Player.Position;
import UI.CommandLine;
import UI.UIObserver;

public class Operation {
    private final CommandLine commandLine = new CommandLine();
    private final EstateController controller = new EstateController();



    public Operation(UIObserver ui) {
        controller.initializeDefaultBuilding(ui);
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
//        commandLine.showPromptMessageInNewline(
//                "是否花费" + controller.get(position).price + "元购买该地产？");
//        if (commandLine.waitForInput() == "Y") {
//            controller.buy(position, name);
//        }
    }

}
