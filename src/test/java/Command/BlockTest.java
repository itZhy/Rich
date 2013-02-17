package Command;

import Estate.Estate;
import Player.Observer;
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

public class BlockTest {
    @Test
    public void it_should_put_a_barricade_at_the_position_of_10() {
        //given
        UIObserver ui = new Map();
        PropsMap propsMap = new PropsMap(ui);
        Command block = new Block(propsMap);
        Observer estate = new Estate(ui);
        Role uncleTuu = new UncleTuu(new Position(0), ui, estate);
        //when
        block.execute(uncleTuu, 10);
        //then
        PropsMap expectedMap = new PropsMap(ui);
        expectedMap.put(new Position(10), new Barricade(uncleTuu.name()));
        assertThat(propsMap, is(expectedMap));
    }
}
