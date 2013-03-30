package assistedScene;

import estate.EstateManager;
import player.Role;
import prop.Point;
import prop.PropManager;
import ui.Map;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GiftSelectorFactoryTest {
    private GiftSelectorFactory factory;
    private PropManager propManager;
    private Role owner;

    @Before
    public void setUp() {
        propManager = new PropManager(new Map());
        factory = new GiftSelectorFactory(propManager, new EstateManager(new Map()));
        owner = Role.uncleTuu;
    }

    @Test
    public void it_should_add_200_point_after_choose_a_() {
        //when
        factory.get("2").select(owner);
        //then
        PropManager expectedPropManager = new PropManager(new Map());
        expectedPropManager.add(owner, new Point(200));
        assertThat(propManager, is(expectedPropManager));
    }
}
