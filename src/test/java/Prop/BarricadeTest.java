package Prop;

import Player.Feature;
import Player.Movement;
import org.junit.Test;

public class BarricadeTest {
    @Test(expected = BlockException.class)
    public void the_role_should_be_blocked_when_forwarding() {
        //given
        Prop barricade = new Barricade(Feature.MADAME_CHYAN);
        //when
        Movement movement = new Movement();
        barricade.handle(movement);
    }
}
