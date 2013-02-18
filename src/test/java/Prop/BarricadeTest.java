package Prop;

import Player.Feature;
import Player.Movement;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BarricadeTest {
    @Test
    public void the_role_should_be_blocked_when_forwarding() {
        //given
        Prop barricade = new Barricade(Feature.MADAME_CHYAN);
        //when
        Movement movement = new Movement();
        barricade.handle(movement);
        movement.walk();
        //then
        assertThat(movement, is(new Movement()));
    }
}
