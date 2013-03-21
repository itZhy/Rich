package prop;

import application.GameException;
import player.Movement;
import player.Observer;
import player.Position;
import ui.UIObserver;

public class PropManager implements Observer {
    private final Ownership ownership = new Ownership();
    private final PlayerPosition playerPosition = new PlayerPosition();
    private final PropMap propMap;

    public PropManager(UIObserver ui) {
        propMap = new PropMap(ui);
    }

    public void handle(String roleName, Movement movement) {
        propMap.trigger(movement);
        playerPosition.record(roleName, movement.currentPosition());
    }

    public void add(String roleName, int point) {
        ownership.add(roleName, point);
    }

    public void sell(String roleName, Prop prop) {
        ownership.sell(roleName, prop);
    }

    public void buy(String roleName, Prop prop) {
        ownership.buy(roleName, prop);
    }

    public void put(String roleName, Prop prop, Position position) {
        if (playerPosition.hasPlayer(position)) {
            throw new GameException("此处有玩家，不能放置道具。", GameException.NEED_RETRY);
        }
        ownership.consume(roleName, prop);
        propMap.put(position, prop);
    }

    public void clean(String roleName, Position position) {
        ownership.consume(roleName, new Robot());
        propMap.cleanTheFront(position);
    }

    public String query(String roleName) {
        return ownership.query(roleName);
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                ownership.equals(((PropManager) object).ownership) &&
                propMap.equals(((PropManager) object).propMap);
    }
}