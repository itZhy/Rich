package Player;

import UI.PositionExtractor;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MovementTest {
    private Movement movement;

    @Before
    public void setUp() {
        movement = new Movement();
    }

    @Test
    public void it_should_change_current_position_to_2() {
        //when
        movement.walk();
        movement.walk();
        //then
        assertThat(movement.currentPosition(), is(new Position(2)));
    }

    @Test
    public void it_should_change_current_position_to_hospital() {
        //when
        movement.jumpToHospital();
        //then
        assertThat(movement.currentPosition(), is(new PositionExtractor().getHospital()));
    }

    @Test
    public void it_should_stop_twice()    {
        //when
        movement.block(2);
        movement.walk();
        movement.walk();
        movement.walk();
        //then
        assertThat(movement.currentPosition(), is(new Position(1)));
    }

    @Test
    public void it_should_skip_only_once()  {
        //when
        movement.block(1);
        boolean firstSkipResult = movement.skip();
        boolean secondSkipResult = movement.skip();
        //then
        assertThat(firstSkipResult, is(true));
        assertThat(secondSkipResult, is(false));
    }
}