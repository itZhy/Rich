package Command;

import Player.*;
import Props.Barricade;
import Props.Ownership;
import Props.PropsMap;
import Estate.Estate;
import UI.Map;
import UI.UIObserver;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BlockTest {
    @Test
    public void it_should_put_a_barricade_at_the_position_of_10() {
        //given
        UIObserver ui = new Map();
        Estate estate = new Estate(ui);
        Role uncleTuu = new UncleTuu(new Position(0), ui, new Callback());
        PropsMap propsMap = new PropsMap(ui);
        Ownership ownership = new Ownership();
        ownership.add(uncleTuu.name(), 50);
        ownership.buy(uncleTuu.name(), new Barricade(uncleTuu.name()));
        Command block = new Block(propsMap, ownership);
        //when
        block.execute(uncleTuu, 10);
        //then
        PropsMap expectedMap = new PropsMap(ui);
        expectedMap.put(new Position(10), new Barricade(uncleTuu.name()));
        assertThat(propsMap, is(expectedMap));
    }
}
