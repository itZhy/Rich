package Player;

import UI.Map;
import UI.Observer;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RounderTest {
    private Observer ui;
    private Rounder rounder;

    @Before
    public void setUp() {
        ui = new Map();
        rounder = new Rounder("4213", ui);
    }

    @Test
    public void it_should_get_first_player() {
        //when
        Player currentPlayer = rounder.getCurrentPlayer();
        //then
        Player exceptedPlayer = new BabyKin(new Position(0), ui);
        assertThat(currentPlayer, is(exceptedPlayer));
    }

    @Test
    public void it_should_get_third_player_when_run_next_twice() {
        //when
        rounder.next();
        rounder.next();
        Player currentPlayer = rounder.getCurrentPlayer();
        //then
        Player exceptedPlayer = new MadameChyan(new Position(0), ui);
        assertThat(currentPlayer, is(exceptedPlayer));
    }

    @Test
    public void it_should_get_first_player_when_run_next_four_times() {
        //when
        rounder.next();
        rounder.next();
        rounder.next();
        rounder.next();
        Player currentPlayer = rounder.getCurrentPlayer();
        //then
        Player exceptedPlayer = new BabyKin(new Position(0), ui);
        assertThat(currentPlayer, is(exceptedPlayer));
    }
}
