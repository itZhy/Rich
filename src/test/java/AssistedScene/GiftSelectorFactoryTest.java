package AssistedScene;

import Estate.Estate;
import Player.Feature;
import Prop.PropManager;
import UI.Map;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GiftSelectorFactoryTest {
    private GiftSelectorFactory factory;
    private PropManager propManager;
    private Estate estate;
    private String owner;

    @Before
    public void setUp() {
        propManager = new PropManager(new Map());
        estate = new Estate(new Map());
        factory = new GiftSelectorFactory(propManager, estate);
        owner = Feature.UNCLE_TUU;
    }

    @Test
    public void it_should_add_200_point_after_choose_a_() {
        //when
        factory.get("2").select(owner);
        //then
        PropManager expectedPropManager = new PropManager(new Map());
        expectedPropManager.add(owner, 200);
        assertThat(propManager, is(expectedPropManager));
    }
}
