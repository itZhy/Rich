package Command;

import Player.Callback;
import Player.Position;
import Player.Role;
import Player.UncleTuu;
import Props.Barricade;
import Props.PropsManager;
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
        PropsManager propsManager = new PropsManager(ui);
        Role uncleTuu = new UncleTuu(new Callback());
        propsManager.add(uncleTuu.name(), 80);
        propsManager.buy(uncleTuu.name(), new Props.Robot());
        propsManager.buy(uncleTuu.name(), new Barricade(uncleTuu.name()));
        propsManager.put(uncleTuu.name(), new Barricade(uncleTuu.name()), new Position(1));
        Command robot = new Robot(propsManager);
        //when
        robot.execute(uncleTuu, 0);
        //then
        PropsManager expectedManager = new PropsManager(ui);
        expectedManager.add(uncleTuu.name(), 0);
        assertThat(propsManager, is(expectedManager));
    }
}
