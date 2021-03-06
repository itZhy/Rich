package prop;

import player.Movement;
import player.PlayerObserver;
import player.Position;
import player.Role;
import ui.UIObserver;
import utils.Checker;

public class PropManager implements PlayerObserver {
    private final Ownership ownership = new Ownership();
    private final PlayerPosition playerPosition = new PlayerPosition();
    private final PropMap propMap;

    public PropManager(UIObserver ui) {
        propMap = new PropMap(ui);
    }

    public void handle(Role role, Movement movement) {
        propMap.trigger(role, movement);
        playerPosition.record(role, movement.currentPosition());
    }

    public void add(Role role, Point point) {
        ownership.add(role, point);
    }

    public void sell(Role role, Prop prop) {
        ownership.sell(role, prop);
    }

    public void buy(Role role, Prop prop) {
        ownership.buy(role, prop);
    }

    public void put(Role role, Prop prop, Position position) {
        Checker.check(!playerPosition.hasPlayer(position), "此处有玩家，不能放置道具。");
        ownership.consume(role, prop);
        propMap.put(role, position, prop);
    }

    public void clean(Role role, Position position) {
        ownership.consume(role, new Robot());
        propMap.cleanTheFront(role, position);
    }

    public String query(Role role) {
        return ownership.query(role);
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                ownership.equals(((PropManager) object).ownership) &&
                propMap.equals(((PropManager) object).propMap);
    }
}