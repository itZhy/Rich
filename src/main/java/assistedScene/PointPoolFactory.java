package assistedScene;

import com.google.common.collect.ImmutableList;
import player.Position;
import prop.Point;
import prop.PropManager;
import ui.PositionExtractor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PointPoolFactory {
    private final PropManager propManager;
    private final ImmutableList<Point> pointsInEachPosition = ImmutableList.of(
            new Point(20), new Point(80), new Point(100), new Point(40), new Point(80), new Point(60));

    public PointPoolFactory(PropManager propManager) {
        this.propManager = propManager;
    }

    public Map<Position, Scene> get() {
        Map<Position, Scene> pointsPools = new HashMap<Position, Scene>();
        List<Position> positions = new PositionExtractor().getPointsPools();
        for (int index = 0; index != positions.size(); ++index) {
            pointsPools.put(positions.get(index), new PointPool(pointsInEachPosition.get(index), propManager));
        }
        return pointsPools;
    }
}
