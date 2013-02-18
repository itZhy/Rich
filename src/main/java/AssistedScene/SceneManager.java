package AssistedScene;

import Estate.Estate;
import Player.Movement;
import Player.Observer;
import Player.Position;
import Props.PropManager;
import UI.PositionExtractor;

import java.util.HashMap;
import java.util.Map;

public class SceneManager implements Observer {
    private final PropManager propManager;
    private final Estate estate;
    private Map<Position, Scene> scenes = new HashMap<Position, Scene>();

    public SceneManager(PropManager propManager, Estate estate) {
        this.propManager = propManager;
        this.estate = estate;
        scenes.putAll(new PointPoolFactory(propManager).get());
        scenes.put(new PositionExtractor().getMagicHouse(), new MagicHouse());
        scenes.put(new PositionExtractor().getGiftHouse(), new GiftHouse());
        scenes.put(new PositionExtractor().getPropHouse(), new PropHouse());
        scenes.put(new PositionExtractor().getPrison(), new Prison());
    }

    public void handle(String roleName, Movement movement) {
        if (scenes.containsKey(movement.currentPosition())) {
            scenes.get(movement.currentPosition()).handle(roleName, movement);
        }
    }


}
