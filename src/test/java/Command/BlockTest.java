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

public class BlockTest {
    @Test
    public void it_should_put_a_barricade_at_the_position_of_10() {
        //given
        UIObserver ui = new Map();
        Role uncleTuu = new UncleTuu(new Callback());
        PropsManager propsManager = new PropsManager(ui);
        propsManager.add(uncleTuu.name(), 50);
        propsManager.buy(uncleTuu.name(), new Barricade(uncleTuu.name()));
        Command block = new Block(propsManager);
        //when
        block.execute(uncleTuu, 10);
        //then
        PropsManager expectedManager = new PropsManager(ui);
        expectedManager.add(uncleTuu.name(), 50);
        expectedManager.buy(uncleTuu.name(), new Barricade(uncleTuu.name()));
        expectedManager.put(uncleTuu.name(), new Barricade(uncleTuu.name()), new Position(10));
        assertThat(propsManager, is(expectedManager));
    }
}
