package Estate;

import Player.Callback;
import Player.Feature;
import Player.Role;
import UI.Map;
import UI.UIObserver;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SkyscraperTest {
    private static final int COST = 200;
    private UIObserver ui = new Map();
    private Skyscraper skyscraper;
    private String role;

    @Before
    public void setUp() {
        Role owner = new Role(Feature.SUN_HSIAO_MEI, new Callback());
        role = owner.getClass().toString();
        skyscraper = new Skyscraper(role, ui, COST);
    }

    @Test
    public void it_should_forbid_operate_player_to_update() {
        //when
        Building updatedBuilding = skyscraper.update(role);
        //then
        assertThat(updatedBuilding, is((Building) null));
    }
}
