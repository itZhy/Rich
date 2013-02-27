package Prop;

import Player.Feature;
import Player.Position;
import UI.Map;
import UI.UIObserver;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PropMapTest {
    private PropMap propMap;
    private UIObserver ui;
    private String owner;

    @Before
    public void setUp() {
        ui = new Map();
        propMap = new PropMap(ui);
        owner = Feature.UNCLE_TUU;
    }

    @Test
    public void it_should_be_empty_map_after_cleaned() {
        //given
        propMap.put(new Position(1), new Barricade(owner));
        propMap.put(new Position(10), new Bomb(owner));
        //when
        propMap.cleanTheFront(new Position(0));
        //then
        assertThat(propMap, is(new PropMap(ui)));
    }

    @Test
    public void it_should_has_only_prop_after_cleaned() {
        //given
        propMap.put(new Position(2), new Barricade(owner));
        propMap.put(new Position(11), new Bomb(owner));
        //when
        propMap.cleanTheFront(new Position(0));
        //then
        PropMap expectedPropMap = new PropMap(ui);
        expectedPropMap.put(new Position(11), new Bomb(owner));
        assertThat(propMap, is(expectedPropMap));
    }
}
