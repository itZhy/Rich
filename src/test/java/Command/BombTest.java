package command;

import player.Callback;
import player.Feature;
import player.Position;
import player.Role;
import prop.PropManager;
import ui.Map;
import ui.UIObserver;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BombTest {
    @Test
    public void it_should_put_a_bomb_at_the_position_of_60() {
        //given
        UIObserver ui = new Map();
        Role uncleTuu = new Role(Feature.UNCLE_TUU, new Callback());
        PropManager propManager = new PropManager(ui);
        propManager.add(uncleTuu.name(), 50);
        propManager.buy(uncleTuu.name(), new prop.Bomb(uncleTuu.name()));
        Command bomb = new Bomb(propManager);
        //when
        bomb.execute(uncleTuu, -10);
        //then
        PropManager expectedManager = new PropManager(ui);
        expectedManager.add(uncleTuu.name(), 50);
        expectedManager.buy(uncleTuu.name(), new prop.Bomb(uncleTuu.name()));
        expectedManager.put(uncleTuu.name(), new prop.Bomb(uncleTuu.name()), new Position(60));
        assertThat(propManager, is(expectedManager));
    }

}
