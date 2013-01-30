package Player;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PlayerTest {
    @Test
    public void its_position_should_be_3_after_forward() {
        //given
        Position initialPosition = new Position(0);
        Player player = new Player(initialPosition);
        //when
        player.forward(3);
        //then
        assertThat(player, is(new Player(new Position(3))));
    }

    @Test
    public void its_position_should_be_1_after_forward_more_than_a_lap() {
        //given
        Position initialPosition = new Position(67);
        Player player = new Player(initialPosition);
        //when
        player.forward(4);
        //then
        assertThat(player, is(new Player(new Position(1))));
    }
}
