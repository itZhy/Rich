package command;

import org.junit.Test;
import player.Callback;
import player.Player;
import player.Role;
import prop.Point;
import prop.PropManager;
import prop.Robot;
import ui.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SellToolTest {
    @Test
    public void it_should_succeed_in_selling_a_bomb() {
        //given
        PropManager propManager = new PropManager(new Map());
        Role owner = Role.SunHsiaoMei;
        propManager.add(owner, new Point(30));
        propManager.buy(owner, new Robot());
        Command sellTool = new SellTool(propManager);
        //when
        sellTool.execute(new Player(owner, new Callback()), 2);
        //then
        PropManager expectedPropManager = new PropManager(new Map());
        expectedPropManager.add(owner, new Point(30));
        assertThat(propManager, is(expectedPropManager));
    }
}
