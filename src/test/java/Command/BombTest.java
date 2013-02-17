package Command;

import Estate.EstateObserver;
import Estate.Estate;
import Player.Position;
import Player.Role;
import Player.UncleTuu;
import UI.Map;
import UI.UIObserver;
import org.junit.Test;

public class BombTest {
    @Test
    public void it_should() {
        //given
        Command bomb = new Bomb();
        UIObserver ui = new Map();
        EstateObserver estate = new Estate(ui);
        Role uncleTuu = new UncleTuu(new Position(0), ui, estate);
        //when
        bomb.execute(uncleTuu, -10);
        //then
    }

}
