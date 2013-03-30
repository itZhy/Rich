package assistedScene;

import player.Position;
import prop.Point;
import prop.PropManager;
import ui.PositionExtractor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PointPoolFactory {
    private final PropManager propManager;
    private final List<Point> pointsInEachPosition = new ArrayList<Point>();

    public PointPoolFactory(PropManager propManager) {
        this.propManager = propManager;
        initializePointsInEachPosition();
    }

    public Map<Position, Scene> get() {
        Map<Position, Scene> pointsPools = new HashMap<Position, Scene>();
        List<Position> positions = new PositionExtractor().getPointsPools();
        for (int index = 0; index != positions.size(); ++index) {
            pointsPools.put(positions.get(index), new PointPool(pointsInEachPosition.get(index), propManager));
        }
        return pointsPools;
    }

    private void initializePointsInEachPosition() {
        pointsInEachPosition.add(new Point(20));
        pointsInEachPosition.add(new Point(80));
        pointsInEachPosition.add(new Point(100));
        pointsInEachPosition.add(new Point(40));
        pointsInEachPosition.add(new Point(80));
        pointsInEachPosition.add(new Point(60));
    }
}
