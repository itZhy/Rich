package Prop;

import Player.Feature;
import Player.Position;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PlayerPositionTest {
    @Test
    public void it_should_return_true_when_input_position_has_a_player()    {
        //given
        PlayerPosition playerPosition = new PlayerPosition();
        //when
        playerPosition.record(Feature.BABY_KIN, new Position(3));
        playerPosition.record(Feature.BABY_KIN, new Position(5));
        //then
        assertThat(playerPosition.hasPlayer(new Position(3)), is(false));
        assertThat(playerPosition.hasPlayer(new Position(5)), is(true));
    }
}
