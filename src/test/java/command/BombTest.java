package command;

import player.Callback;
import player.Role;
import player.Position;
import player.Player;
import prop.Point;
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
        Player uncleTuu = new Player(Role.uncleTuu, new Callback());
        PropManager propManager = new PropManager(ui);
        propManager.add(uncleTuu.role(), new Point(50));
        propManager.buy(uncleTuu.role(), new prop.Bomb());
        Command bomb = new Bomb(propManager);
        //when
        bomb.execute(uncleTuu, -10);
        //then
        PropManager expectedManager = new PropManager(ui);
        expectedManager.add(uncleTuu.role(), new Point(50));
        expectedManager.buy(uncleTuu.role(), new prop.Bomb());
        expectedManager.put(uncleTuu.role(), new prop.Bomb(), new Position(60));
        assertThat(propManager, is(expectedManager));
    }

}
