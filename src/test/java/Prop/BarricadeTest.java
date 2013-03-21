package prop;

import player.Role;
import player.Movement;
import org.junit.Test;

public class BarricadeTest {
    @Test(expected = PropException.class)
    public void the_role_should_be_blocked_when_forwarding() {
        //given
        Prop barricade = new Barricade(Role.madameChyan);
        //when
        Movement movement = new Movement();
        barricade.handle(movement);
    }
}
