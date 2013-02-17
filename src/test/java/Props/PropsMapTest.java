package Props;

import Player.Position;
import Player.UncleTuu;
import UI.Map;
import UI.UIObserver;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PropsMapTest {
    private PropsMap propsMap;
    private UIObserver ui;
    private String owner;

    @Before
    public void setUp() {
        ui = new Map();
        propsMap = new PropsMap(ui);
        owner = UncleTuu.class.toString();
    }

    @Test
    public void it_should_be_empty_map_after_cleaned() {
        //given
        propsMap.put(new Position(1), new Barricade(owner));
        propsMap.put(new Position(10), new Bomb(owner));
        //when
        propsMap.cleanTheFront(new Position(0));
        //then
        assertThat(propsMap, is(new PropsMap(ui)));
    }

    @Test
    public void it_should_has_only_prop_after_cleaned() {
        //given
        propsMap.put(new Position(2), new Barricade(owner));
        propsMap.put(new Position(11), new Bomb(owner));
        //when
        propsMap.cleanTheFront(new Position(0));
        //then
        PropsMap expectedPropsMap = new PropsMap(ui);
        expectedPropsMap.put(new Position(11), new Bomb(owner));
        assertThat(propsMap, is(expectedPropsMap));
    }
}
