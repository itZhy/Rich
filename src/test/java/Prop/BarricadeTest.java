package Prop;

import Player.*;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BarricadeTest {
    @Test
    public void the_role_should_be_blocked_when_forwarding() {
        //given
        String owner = MadameChyan.class.toString();
        Prop barricade = new Barricade(owner);
        //when
        Movement movement = new Movement();
        barricade.handle(movement);
        movement.walk();
        //then
        assertThat(movement, is(new Movement()));
    }
}
