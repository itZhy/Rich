package Player;

import Estate.BuildingObserver;
import Estate.Estate;
import UI.Map;
import UI.Observer;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RoleTest {
    private Observer ui;
    private BuildingObserver building;
    @Before
    public void setUP() {
        ui = new Map();
        building = new Estate(ui);
    }

    @Test
    public void its_position_should_be_3_after_forward() {
        //given
        Position initialPosition = new Position(0);
        Role role = new MadameChyan(initialPosition, ui, building);
        //when
        role.forward(3);
        //then
        Role exceptedRole = new MadameChyan(new Position(3), ui, building);
        assertThat(role, is(exceptedRole));
    }

    @Test
    public void its_position_should_be_1_after_forward_more_than_a_lap() {
        //given
        Position initialPosition = new Position(67);
        Role role = new MadameChyan(initialPosition, ui, building);
        //when
        role.forward(4);
        //then
        Role exceptedRole = new MadameChyan(new Position(1), ui, building);
        assertThat(role, is(exceptedRole));
    }
}
