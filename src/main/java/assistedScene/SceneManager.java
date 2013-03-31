package assistedScene;

import estate.EstateManager;
import player.Movement;
import player.PlayerObserver;
import player.Position;
import player.Role;
import prop.PropManager;
import ui.PositionExtractor;

import java.util.HashMap;
import java.util.Map;

public class SceneManager implements PlayerObserver {
    private final Map<Position, Scene> scenes = new HashMap<Position, Scene>();

    public SceneManager(PropManager propManager, EstateManager estateManager) {
        final PositionExtractor positionExtractor = new PositionExtractor();
        scenes.putAll(new PointPoolFactory(propManager).get());
        scenes.put(positionExtractor.getMagicHouse(), new MagicHouse());
        scenes.put(positionExtractor.getGiftHouse(), new GiftHouse(propManager, estateManager));
        scenes.put(positionExtractor.getPropHouse(), new PropHouse(propManager));
        scenes.put(positionExtractor.getPrison(), new Prison());
    }

    public void handle(Role role, Movement movement) {
        if (scenes.containsKey(movement.currentPosition())) {
            scenes.get(movement.currentPosition()).handle(role, movement);
        }
    }
}