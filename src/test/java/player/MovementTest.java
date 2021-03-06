package player;

import org.junit.Before;
import org.junit.Test;
import ui.PositionExtractor;

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
    public void it_should_skip_only_once() {
        //given
        movement.block(1);
        //then
        assertThat(movement.isNeedNotSkip(), is(false));
        //when
        movement.pass();
        //then
        assertThat(movement.isNeedNotSkip(), is(true));
    }

    @Test
    public void it_should_be_leaved_after_leave() {
        assertThat(movement.isLeaved(), is(false));
        //given
        movement.leave();
        //then
        assertThat(movement.isLeaved(), is(true));
    }
}