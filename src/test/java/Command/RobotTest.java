package Command;

import Player.Callback;
import Player.Position;
import Player.Role;
import Player.UncleTuu;
import Props.Barricade;
import Props.Ownership;
import Props.PropsMap;
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
        PropsMap propsMap = new PropsMap(ui);
        Role uncleTuu = new UncleTuu(new Callback());
        propsMap.put(new Position(10), new Barricade(uncleTuu.name()));
        Ownership ownership = new Ownership();
        ownership.add(uncleTuu.name(), 30);
        ownership.buy(uncleTuu.name(), new Props.Robot());
        Command robot = new Robot(propsMap, ownership);
        //when
        robot.execute(uncleTuu, 10);
        //then
        assertThat(propsMap, is(new PropsMap(ui)));
    }
}
