package Estate;

import Player.MadameChyan;
import Player.Role;
import Player.Position;
import Player.UncleTuu;
import UI.Map;
import UI.Observer;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class EstateTest {
    private Estate estate;
    private Observer ui;

    @Before
    public void setUP() {
        ui = new Map();
        estate = new Estate(ui);
        estate.add(MadameChyan.class.toString());
        estate.add(UncleTuu.class.toString());
    }

    @Test
    public void it_should_operate_player_to_buy_house() {
        //given
        Role role = new MadameChyan(new Position(3), ui, estate);
        //when
    }

}
