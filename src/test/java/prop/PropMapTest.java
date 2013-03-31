package prop;

import org.junit.Before;
import org.junit.Test;
import player.Position;
import player.Role;
import ui.Map;
import ui.UIObserver;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PropMapTest {
    private PropMap propMap;
    private UIObserver ui;
    private Role owner;

    @Before
    public void setUp() {
        ui = new Map();
        propMap = new PropMap(ui);
        owner = Role.uncleTuu;
    }

    @Test
    public void it_should_be_empty_map_after_cleaned() {
        //given
        propMap.put(owner, new Position(1), new Barricade());
        propMap.put(owner, new Position(10), new Bomb());
        //when
        propMap.cleanTheFront(owner, new Position(0));
        //then
        assertThat(propMap, is(new PropMap(ui)));
    }

    @Test
    public void it_should_has_only_prop_after_cleaned() {
        //given
        propMap.put(owner, new Position(2), new Barricade());
        propMap.put(owner, new Position(11), new Bomb());
        //when
        propMap.cleanTheFront(owner, new Position(0));
        //then
        PropMap expectedPropMap = new PropMap(ui);
        expectedPropMap.put(owner, new Position(11), new Bomb());
        assertThat(propMap, is(expectedPropMap));
    }
}
