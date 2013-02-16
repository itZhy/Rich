package Props;

import Player.Position;
import Player.Role;
import Player.UncleTuu;
import UI.Map;
import UI.Observer;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PropsMapTest {
    PropsMap propsMap;
    Observer ui;
    Role uncleTuu;

    @Before
    public void setUp() {
        propsMap = new PropsMap();
        ui = new Map();
        uncleTuu = new UncleTuu(new Position(0), ui);
    }

    @Test
    public void it_should_be_empty_map_after_cleaned() {
        //given
        propsMap.put(new Position(1), new Barricade(uncleTuu, ui));
        propsMap.put(new Position(10), new Bomb(uncleTuu, ui));
        //when
        propsMap.cleanTheFront(new Position(0));
        //then
        assertThat(propsMap, is(new PropsMap()));
    }

    @Test
    public void it_should_has_only_prop_after_cleaned() {
       //given
        propsMap.put(new Position(2), new Barricade(uncleTuu, ui));
        propsMap.put(new Position(11), new Bomb(uncleTuu, ui));
        //when
        propsMap.cleanTheFront(new Position(0));
        //then
        PropsMap expectedPropsMap = new PropsMap();
        expectedPropsMap.put(new Position(11), new Bomb(uncleTuu, ui));
        assertThat(propsMap, is(expectedPropsMap));
    }
}
