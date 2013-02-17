package Command;

import Player.*;
import Props.Ownership;
import Props.PropsMap;
import UI.Map;
import UI.UIObserver;
import Estate.Estate;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BombTest {
    @Test
    public void it_should_put_a_bomb_at_the_position_of_60() {
        //given
        UIObserver ui = new Map();
        Callback callback = new Callback();
        Role uncleTuu = new UncleTuu(callback, callback);
        PropsMap propsMap = new PropsMap(ui);
        Ownership ownership = new Ownership();
        ownership.add(uncleTuu.name(), 50);
        ownership.buy(uncleTuu.name(), new Props.Bomb(uncleTuu.name()));
        Command bomb = new Bomb(propsMap, ownership);
        //when
        bomb.execute(uncleTuu, -10);
        //then
        PropsMap expectedMap = new PropsMap(ui);
        expectedMap.put(new Position(60), new Props.Bomb(uncleTuu.name()));
        assertThat(propsMap, is(expectedMap));
    }

}
