package Command;

import Player.Callback;
import Player.Feature;
import Player.Position;
import Player.Role;
import Prop.Barricade;
import Prop.PropManager;
import UI.Map;
import UI.UIObserver;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class RobotTest {
    @Test
    public void it_should_clean_the_props_in_front() {
        //given
        UIObserver ui = new Map();
        PropManager propManager = new PropManager(ui);
        Role uncleTuu = new Role(Feature.UNCLE_TUU, new Callback());
        propManager.add(uncleTuu.name(), 80);
        propManager.buy(uncleTuu.name(), new Prop.Robot());
        propManager.buy(uncleTuu.name(), new Barricade(uncleTuu.name()));
        propManager.put(uncleTuu.name(), new Barricade(uncleTuu.name()), new Position(1));
        Command robot = new Robot(propManager);
        //when
        robot.execute(uncleTuu, 0);
        //then
        PropManager expectedManager = new PropManager(ui);
        expectedManager.add(uncleTuu.name(), 0);
        assertThat(propManager, is(expectedManager));
    }
}
