package Estate;

import Player.Callback;
import Player.SunHsiaoMei;
import UI.Map;
import UI.UIObserver;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SkyscraperTest {
    private UIObserver ui = new Map();
    private Skyscraper skyscraper;
    private String role;
    private final Integer COST = 200;

    @Before
    public void setUp() {
        SunHsiaoMei owner = new SunHsiaoMei(new Callback());
        role = owner.getClass().toString();
        skyscraper = new Skyscraper(role, ui, COST);
    }

    @Test
    public void it_should_forbid_operate_player_to_update() {
        //when
        Building updatedBuilding = skyscraper.update(role);
        //then
        Building villa= new Skyscraper(role, ui, COST);
        assertThat(updatedBuilding, is((Building)null));
    }
}
