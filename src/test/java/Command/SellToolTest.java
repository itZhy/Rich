package Command;

import Player.Callback;
import Player.Feature;
import Player.Role;
import Prop.PropManager;
import Prop.Robot;
import UI.Map;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SellToolTest {
    @Test
    public void it_should_succeed_in_selling_a_bomb() {
        //given
        PropManager propManager = new PropManager(new Map());
        String owner = Feature.SUN_HSIAO_MEI;
        propManager.add(owner, 30);
        propManager.buy(owner, new Robot());
        Command sellTool = new SellTool(propManager);
        //when
        sellTool.execute(new Role(owner, new Callback()), 2);
        //then
        PropManager expectedPropManager = new PropManager(new Map());
        expectedPropManager.add(owner, 30);
        assertThat(propManager, is(expectedPropManager));
    }
}
