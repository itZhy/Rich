package Prop;

import Player.*;
import UI.Map;
import UI.UIObserver;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BombTest {
    @Test
    public void the_role_should_be_moved_to_hospital() {
        //given
        UIObserver ui = new Map();
        String owner = UncleTuu.class.toString();
        Prop bomb = new Bomb(owner);
        //when
        Movement movement = new Movement();
        bomb.handle(movement);
        //then
        Movement exceptedMovement = new Movement();
        exceptedMovement.jumpToHospital();
        assertThat(movement, is(exceptedMovement));
    }
}
