package estate;

import org.junit.Before;
import org.junit.Test;
import player.Position;
import player.Role;
import ui.Map;
import ui.UIObserver;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class EstateMapTest {
    private UIObserver ui;
    private EstateMap map;

    @Before
    public void setUp() {
        ui = new Map();
        map = new EstateMap(ui);
    }

    @Test
    public void it_should_update_building_after_payed() {
        //when
        map.update(new Position(10), Role.madameChyan);
        map.update(new Position(10), Role.madameChyan);
        //then
        assertThat(map.get(new Position(10)), is((Building) new Hovel(Role.madameChyan, new Money(200.))));
    }

    @Test
    public void it_should_clear_associated_building() {
        //when
        map.update(new Position(10), Role.madameChyan);
        map.clearBuilding(new Position(10));
        //then
        assertThat(map, is(new EstateMap(ui)));
    }

    @Test
    public void it_should_clear_all_buildings_of_player_after_insolvency() {
        //when
        map.update(new Position(10), Role.madameChyan);
        map.update(new Position(24), Role.madameChyan);
        map.update(new Position(25), Role.babyKin);
        map.clearBuildingsOfOwner(Role.madameChyan);
        //then
        EstateMap exceptedMap = new EstateMap(ui);
        exceptedMap.update(new Position(25), Role.babyKin);
        assertThat(map, is(exceptedMap));
    }

    @Test
    public void it_should_inquiry_buildings_which_match_the_role() {
        //when
        map.update(new Position(10), Role.madameChyan);
        map.update(new Position(24), Role.madameChyan);
        map.update(new Position(25), Role.madameChyan);

        map.update(new Position(10), Role.madameChyan);
        map.update(new Position(24), Role.madameChyan);
        map.update(new Position(24), Role.madameChyan);
        //then
        assertThat(map.query(Role.madameChyan), is("地产：空地1处；茅屋1处；洋房1处；摩天楼0处"));
    }

    @Test
    public void it_should_check_current_position_is_building_or_not() {
        assertThat(map.hasBuilding(new Position(19)), is(true));
        assertThat(map.hasBuilding(new Position(0)), is(false));
    }
}
