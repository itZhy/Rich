package command;

import org.junit.Test;
import player.Callback;
import player.Player;
import player.Position;
import player.Role;
import prop.Barricade;
import prop.Point;
import prop.PropManager;
import ui.Map;
import ui.UIObserver;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class RobotTest {
    @Test
    public void it_should_clean_the_props_in_front() {
        //given
        UIObserver ui = new Map();
        PropManager propManager = new PropManager(ui);
        Player uncleTuu = new Player(Role.uncleTuu, new Callback());
        propManager.add(uncleTuu.role(), new Point(80));
        propManager.buy(uncleTuu.role(), new prop.Robot());
        propManager.buy(uncleTuu.role(), new Barricade());
        propManager.put(uncleTuu.role(), new Barricade(), new Position(1));
        Command robot = new Robot(propManager);
        //when
        robot.execute(uncleTuu, 0);
        //then
        PropManager expectedManager = new PropManager(ui);
        expectedManager.add(uncleTuu.role(), new Point(0));
        assertThat(propManager, is(expectedManager));
    }
}
