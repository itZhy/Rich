package Player;

import UI.Map;
import UI.Observer;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PlayerTest {
    private Observer ui;
    @Before
    public void setUP() {
        ui = new Map();
    }

    @Test
    public void its_position_should_be_3_after_forward() {
        //given
        Position initialPosition = new Position(0);
        Player player = new MadameChyan(initialPosition, ui);
        //when
        player.forward(3);
        //then
        Player exceptedPlayer = new MadameChyan(new Position(3), ui);
        assertThat(player, is(exceptedPlayer));
    }

    @Test
    public void its_position_should_be_1_after_forward_more_than_a_lap() {
        //given
        Position initialPosition = new Position(67);
        Player player = new MadameChyan(initialPosition, ui);
        //when
        player.forward(4);
        //then
        Player exceptedPlayer = new MadameChyan(new Position(1), ui);
        assertThat(player, is(exceptedPlayer));
    }
}
