package command;

import org.junit.Test;
import player.Callback;
import player.Player;
import player.Position;
import player.Role;
import prop.Barricade;
import prop.Point;
import prop.PropManager;
import ui.Map;
import ui.UIObserver;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BlockTest {
    @Test
    public void it_should_put_a_barricade_at_the_position_of_10() {
        //given
        UIObserver ui = new Map();
        Player uncleTuu = new Player(Role.uncleTuu, new Callback());
        PropManager propManager = new PropManager(ui);
        propManager.add(uncleTuu.role(), new Point(50));
        propManager.buy(uncleTuu.role(), new Barricade());
        Command block = new Block(propManager);
        //when
        block.execute(uncleTuu, 10);
        //then
        PropManager expectedManager = new PropManager(ui);
        expectedManager.add(uncleTuu.role(), new Point(50));
        expectedManager.buy(uncleTuu.role(), new Barricade());
        expectedManager.put(uncleTuu.role(), new Barricade(), new Position(10));
        assertThat(propManager, is(expectedManager));
    }
}
