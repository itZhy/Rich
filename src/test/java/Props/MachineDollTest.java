package Props;

import Estate.Estate;
import Player.MadameChyan;
import Player.Position;
import Player.Role;
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
        Role role = new MadameChyan(new Position(0), ui, new Estate(ui));
        PropsMap map = new PropsMap();
        map.put(new Position(10), new Barricade(role, ui));
        MachineDoll machineDoll = new MachineDoll(ui, map);
        //when
        machineDoll.handle(new Position(0), new MadameChyan(new Position(0), ui, new Estate(ui)));
        //then
        assertThat(map, is(new PropsMap()));
    }
}
