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

public class BlockTest {
    @Test
    public void it_should_put_a_barricade_at_the_position_of_10() {
        //given
        UIObserver ui = new Map();
        Role uncleTuu = new Role(Feature.UNCLE_TUU, new Callback());
        PropManager propManager = new PropManager(ui);
        propManager.add(uncleTuu.name(), 50);
        propManager.buy(uncleTuu.name(), new Barricade(uncleTuu.name()));
        Command block = new Block(propManager);
        //when
        block.execute(uncleTuu, 10);
        //then
        PropManager expectedManager = new PropManager(ui);
        expectedManager.add(uncleTuu.name(), 50);
        expectedManager.buy(uncleTuu.name(), new Barricade(uncleTuu.name()));
        expectedManager.put(uncleTuu.name(), new Barricade(uncleTuu.name()), new Position(10));
        assertThat(propManager, is(expectedManager));
    }
}
