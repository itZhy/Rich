package Command;

import Player.Observer;
import Estate.Estate;
import Player.Position;
import Player.Role;
import Player.UncleTuu;
import Props.PropsMap;
import UI.Map;
import UI.UIObserver;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BombTest {
    @Test
    public void it_should_put_a_bomb_at_the_position_of_60() {
        //given
        UIObserver ui = new Map();
        Observer estate = new Estate(ui);
        PropsMap propsMap = new PropsMap(ui);
        Command bomb = new Bomb(propsMap);
        Role uncleTuu = new UncleTuu(new Position(0), ui, estate);
        //when
        bomb.execute(uncleTuu, -10);
        //then
        PropsMap expectedMap = new PropsMap(ui);
        expectedMap.put(new Position(60), new Props.Bomb(uncleTuu.name()));
        assertThat(propsMap, is(expectedMap));
    }

}
