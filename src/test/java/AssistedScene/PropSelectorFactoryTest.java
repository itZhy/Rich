package AssistedScene;

import Player.UncleTuu;
import Prop.Barricade;
import Prop.PropManager;
import UI.Map;
import UI.UIException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PropSelectorFactoryTest {
    private PropSelectorFactory factory;
    private PropManager propManager;
    private String owner;

    @Before
    public void setUp() {
        propManager = new PropManager(new Map());
        factory = new PropSelectorFactory(propManager);
        owner = UncleTuu.class.toString();
    }

    @Test(expected = UIException.class)
    public void it_should_not_afford_any_prop() {
        //when
        factory.get("1").select(owner);
    }

    @Test
    public void it_should_afford_a_barricade() {
        //when
        propManager.add(owner, 50);
        factory.get("1").select(owner);
        //then
        PropManager expectedPropManager = new PropManager(new Map());
        expectedPropManager.add(owner, 50);
        expectedPropManager.buy(owner, new Barricade(owner));
        assertThat(propManager, is(expectedPropManager));
    }

    @Test
    public void it_should_get_an_exception_which_means_need_not_retry() {
        try {
            //when
            factory.get("F").select(owner);
        } catch (UIException e) {
            //then
            assertThat(e.isNeedRetry(), is(false));
        }
    }
}
