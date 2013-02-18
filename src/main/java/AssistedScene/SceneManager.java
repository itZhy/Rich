package AssistedScene;

import Player.Movement;
import Player.Observer;
import Player.Position;
import Props.PropsManager;

import java.util.HashMap;
import java.util.Map;

public class SceneManager implements Observer {
    private final PropsManager propsManager;
    private Map<Position, Scene> scenes = new HashMap<Position, Scene>();

    public SceneManager(PropsManager propsManager) {
        this.propsManager = propsManager;
        scenes.putAll(new PointsPoolFactory(propsManager).get());
    }

    public void handle(String roleName, Movement movement) {
        if (scenes.containsKey(movement.currentPosition())) {
            scenes.get(movement.currentPosition()).handle(roleName, movement);
        }
    }


}
