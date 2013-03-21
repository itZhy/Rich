package assistedScene;

import estate.EstateManager;
import player.Movement;
import player.Observer;
import player.Position;
import player.Role;
import prop.PropManager;
import ui.PositionExtractor;

import java.util.HashMap;
import java.util.Map;

public class SceneManager implements Observer {
    private final Map<Position, Scene> scenes = new HashMap<Position, Scene>();

    public SceneManager(PropManager propManager, EstateManager estateManager) {
        initializeScenes(propManager, estateManager);
    }

    private void initializeScenes(PropManager propManager, EstateManager estateManager) {
        scenes.putAll(new PointPoolFactory(propManager).get());
        scenes.put(new PositionExtractor().getMagicHouse(), new MagicHouse());
        scenes.put(new PositionExtractor().getGiftHouse(), new GiftHouse(propManager, estateManager));
        scenes.put(new PositionExtractor().getPropHouse(), new PropHouse(propManager));
        scenes.put(new PositionExtractor().getPrison(), new Prison());
    }

    public void handle(Role role, Movement movement) {
        if (scenes.containsKey(movement.currentPosition())) {
            scenes.get(movement.currentPosition()).handle(role, movement);
        }
    }
}