package Command;

import Estate.Estate;
import Player.*;
import Props.Manager;
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
        Callback callback = new Callback();
        Observer estate = new Estate(ui);
        Role uncleTuu = new UncleTuu(new Position(0), ui, callback);
        PropsMap propsMap = new PropsMap(ui);
        Manager propsManager = new Manager();
        propsManager.add(uncleTuu.name(), 50);
        propsManager.buy(uncleTuu.name(), new Props.Bomb(uncleTuu.name()));
        Command bomb = new Bomb(propsMap, propsManager);
        //when
        bomb.execute(uncleTuu, -10);
        //then
        PropsMap expectedMap = new PropsMap(ui);
        expectedMap.put(new Position(60), new Props.Bomb(uncleTuu.name()));
        assertThat(propsMap, is(expectedMap));
    }

}
