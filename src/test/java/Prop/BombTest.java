package prop;

import player.Feature;
import player.Movement;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BombTest {
    @Test
    public void the_role_should_be_moved_to_hospital() {
        //given
        Prop bomb = new Bomb(Feature.UNCLE_TUU);
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
