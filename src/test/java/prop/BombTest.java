package prop;

import org.junit.Test;
import player.Movement;
import player.Role;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BombTest {
    @Test
    public void the_role_should_be_moved_to_hospital() {
        //given
        Prop bomb = new Bomb();
        //when
        Movement movement = new Movement();
        try {
            bomb.handle(movement);
        } catch (PropException e) {
        }
        //then
        Movement exceptedMovement = new Movement();
        exceptedMovement.jumpToHospital();
        assertThat(movement, is(exceptedMovement));
    }
}
