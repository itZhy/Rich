package prop;

import player.Role;
import player.Position;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PlayerPositionTest {
    @Test
    public void it_should_return_true_when_input_position_has_a_player()    {
        //given
        PlayerPosition playerPosition = new PlayerPosition();
        //when
        playerPosition.record(Role.babyKin, new Position(3));
        playerPosition.record(Role.babyKin, new Position(5));
        //then
        assertThat(playerPosition.hasPlayer(new Position(3)), is(false));
        assertThat(playerPosition.hasPlayer(new Position(5)), is(true));
    }
}
