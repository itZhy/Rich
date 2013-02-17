package Command;

import Player.Callback;
import Player.Position;
import Player.Role;
import Player.UncleTuu;
import Props.PropsManager;
import UI.Map;
import UI.UIObserver;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BombTest {
    @Test
    public void it_should_put_a_bomb_at_the_position_of_60() {
        //given
        UIObserver ui = new Map();
        Role uncleTuu = new UncleTuu(new Callback());
        PropsManager propsManager = new PropsManager(ui);
        propsManager.add(uncleTuu.name(), 50);
        propsManager.buy(uncleTuu.name(), new Props.Bomb(uncleTuu.name()));
        Command bomb = new Bomb(propsManager);
        //when
        bomb.execute(uncleTuu, -10);
        //then
        PropsManager expectedManager = new PropsManager(ui);
        expectedManager.add(uncleTuu.name(), 50);
        expectedManager.buy(uncleTuu.name(), new Props.Bomb(uncleTuu.name()));
        expectedManager.put(uncleTuu.name(), new Props.Bomb(uncleTuu.name()), new Position(60));
        assertThat(propsManager, is(expectedManager));
    }

}
