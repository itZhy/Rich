package Player;

<<<<<<< HEAD
import UI.Element;
=======
import Estate.EstateObserver;
>>>>>>> f94b8cbeedcafb5de5b8b0b03de8cbe5081d0601
import UI.UIObserver;

public class SunHsiaoMei extends Role {
<<<<<<< HEAD
    private final Ansi.Color color = Ansi.Color.YELLOW;

    public SunHsiaoMei(Position initialPosition, UIObserver ui, Observer building) {
=======
    public SunHsiaoMei(Position initialPosition, UIObserver ui, EstateObserver building) {
>>>>>>> f94b8cbeedcafb5de5b8b0b03de8cbe5081d0601
        super(initialPosition, ui, building);
    }

    public String getPromptMessage() {
        return "孙美美>";
    }

    protected void updateUI(Position source, Position destination) {
        ui.move(source, destination, new RoleColor().dye(name(), 'S'));
    }
}
