package Command;

import Estate.Estate;
import Estate.EstateObserver;
import Player.Position;
import Player.Role;
import Player.UncleTuu;
import Props.Barricade;
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
        EstateObserver estate = new Estate(ui);
        Role uncleTuu = new UncleTuu(new Position(0), ui, estate);
        propsMap.put(new Position(10), new Barricade(uncleTuu.name()));
        Command robot = new Robot(propsMap);
        //when
        robot.execute(uncleTuu, 10);
        //then
        assertThat(propsMap, is( new PropsMap(ui)));
    }
}
