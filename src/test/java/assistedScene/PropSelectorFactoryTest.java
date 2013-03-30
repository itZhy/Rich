package assistedScene;

import application.GameException;
import org.junit.Before;
import org.junit.Test;
import player.Role;
import prop.Barricade;
import prop.Point;
import prop.PropManager;
import ui.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PropSelectorFactoryTest {
    private PropSelectorFactory factory;
    private PropManager propManager;
    private Role owner;

    @Before
    public void setUp() {
        propManager = new PropManager(new Map());
        factory = new PropSelectorFactory(propManager);
        owner = Role.uncleTuu;
    }

    @Test(expected = GameException.class)
    public void it_should_not_afford_any_prop() {
        //when
        factory.get("1").select(owner);
    }

    @Test
    public void it_should_afford_a_barricade() {
        //when
        propManager.add(owner, new Point(50));
        factory.get("1").select(owner);
        //then
        PropManager expectedPropManager = new PropManager(new Map());
        expectedPropManager.add(owner, new Point(50));
        expectedPropManager.buy(owner, new Barricade(owner));
        assertThat(propManager, is(expectedPropManager));
    }
}
