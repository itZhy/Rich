package Player;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PositionTest {
    @Test
    public void it_should_return_new_position_at_4_after_moved() {
        //given
        Position source = new Position(1);
        //when
        Position destination = source.offset(3);
        //then
        assertThat(destination, is(new Position(4)));
    }

    @Test
    public void it_should_return_new_position_at_69_after_moved_back() {
        //given
        Position source = new Position(1);
        //when
        Position destination = source.offset(-2);
        //then
        assertThat(destination, is(new Position(69)));
    }
}
