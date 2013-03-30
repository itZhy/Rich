package prop;

import application.GameException;
import player.Movement;
import player.PlayerObserver;
import player.Position;
import player.Role;
import ui.UIObserver;

public class PropManager implements PlayerObserver {
    private final Ownership ownership = new Ownership();
    private final PlayerPosition playerPosition = new PlayerPosition();
    private final PropMap propMap;

    public PropManager(UIObserver ui) {
        propMap = new PropMap(ui);
    }

    public void handle(Role role, Movement movement) {
        propMap.trigger(movement);
        playerPosition.record(role, movement.currentPosition());
    }

    public void add(Role role, int point) {
        ownership.add(role, point);
    }

    public void sell(Role role, Prop prop) {
        ownership.sell(role, prop);
    }

    public void buy(Role role, Prop prop) {
        ownership.buy(role, prop);
    }

    public void put(Role role, Prop prop, Position position) {
        if (playerPosition.hasPlayer(position)) {
            throw new GameException("此处有玩家，不能放置道具。", GameException.NEED_RETRY);
        }
        ownership.consume(role, prop);
        propMap.put(position, prop);
    }

    public void clean(Role role, Position position) {
        ownership.consume(role, new Robot());
        propMap.cleanTheFront(position);
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