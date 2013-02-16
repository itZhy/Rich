package Player;

import Estate.BuildingObserver;
import UI.Element;
import UI.UIObserver;
import org.fusesource.jansi.Ansi;

public abstract class Role {
    private static final Position HOSPITAL = new Position(14);
    private Position currentPosition;
    private int remainTimes = 0;
    private final BuildingObserver building;
    protected final UIObserver ui;
    private boolean isBlocked = false;


    Role(Position initialPosition, UIObserver ui, BuildingObserver building) {
        currentPosition = initialPosition;
        this.ui = ui;
        this.building = building;
    }

    public String name() {
        return getClass().toString();
    }

    public void forward(int step) {
        for (int count = 1; count <= step; ++count) {
            updateUI(currentPosition, currentPosition.move(1));
            currentPosition = currentPosition.move(1);
            if (isBlocked) {
                isBlocked = false;
                break;
            }
        }
        handleEstate();
    }

    public void stay(int times) {
        remainTimes = times;
    }

    public boolean skip() {
        if (0 == remainTimes) {
            return false;
        }
        --remainTimes;
        return true;
    }

    public void moveToHospital() {
        updateUI(currentPosition, HOSPITAL);
        currentPosition = HOSPITAL;
        stay(3);
    }

    public void block() {
        isBlocked = true;
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                currentPosition.equals(((Role) object).currentPosition) &&
                building.equals(((Role) object).building) &&
                ui.equals(((Role) object).ui) &&
                remainTimes == ((Role) object).remainTimes &&
                isBlocked == ((Role) object).isBlocked;
    }

    public abstract String getPromptMessage();

    public abstract Element getElement(char symbol);

    protected abstract void updateUI(Position source, Position destination);

    protected abstract Ansi.Color getEstateColor();

    private void handleEstate() {
        building.handle(currentPosition, getClass().toString(), getEstateColor());
    }

}
