package prop;

import org.junit.Test;
import player.Movement;

public class BarricadeTest {
    @Test(expected = PropException.class)
    public void the_role_should_be_blocked_when_forwarding() {
        //given
        Prop barricade = new Barricade();
        //when
        Movement movement = new Movement();
        barricade.handle(movement);
    }
}
