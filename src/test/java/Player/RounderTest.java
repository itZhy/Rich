package Player;

import UI.Map;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RounderTest {

    @Test
    public void it_should_get_next_player(){
        //given
        Map map = new Map();
        Rounder rounder = new Rounder("123", map);
        //when
        Player currentPlayer = rounder.next();
        //then
        Player exceptedPlayer = new MadameChyan(new Position(0), map);
        assertThat(currentPlayer, is(exceptedPlayer));
    }

    @Test
    public void it_should_get_multiply_times_next_player(){
        //given
        Map map = new Map();
        Rounder rounder = new Rounder("3241", map);
        //when
        rounder.next();
        rounder.next();
        Player currentPlayer = rounder.next();
        //then
        Player exceptedPlayer = new BabyKin(new Position(0), map);
        assertThat(currentPlayer, is(exceptedPlayer));
    }

    @Test
    public void it_should_get_once_circle_next_player(){
        //given
        Map map = new Map();
        Rounder rounder = new Rounder("324", map);
        //when
        rounder.next();
        rounder.next();
        rounder.next();
        rounder.next();
        Player currentPlayer = rounder.next();
        //then
        Player exceptedPlayer = new UncleTuu(new Position(0), map);
        assertThat(currentPlayer, is(exceptedPlayer));
    }
}
