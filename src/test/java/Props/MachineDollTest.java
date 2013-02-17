package Props;

import Estate.Estate;
import Player.MadameChyan;
import Player.Position;
import UI.Map;
import UI.UIObserver;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MachineDollTest {
    @Test
    public void it_should_be_empty_props_map_after_use_machine_doll() {
        //given
        UIObserver ui = new Map();
        String owner = MadameChyan.class.toString();
        PropsMap propsMap = new PropsMap(ui);
        propsMap.put(new Position(10), new Barricade(owner));
        MachineDoll machineDoll = new MachineDoll(propsMap);
        //when
        machineDoll.handle(new Position(0), new MadameChyan(new Position(0), ui, new Estate(ui)));
        //then
        assertThat(propsMap, is(new PropsMap(ui)));
    }
}
