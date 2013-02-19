package Estate;

import Player.Callback;
import Player.Feature;
import Player.Role;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class VipManagerTest {
    @Test
    public void it_should_set_vip_when_mascot_coming_and_sustained_five_times() {
        //given
        VipManager manager = new VipManager();
        //when
        Role owner = new Role(Feature.SUN_HSIAO_MEI, new Callback());
        String role = owner.name();
        manager.setVip(role);
        //then
        assertThat(manager.vipStatus(role), is(true));
        manager.pass();
        assertThat(manager.vipStatus(role), is(true));
        manager.pass();
        manager.pass();
        manager.pass();
        assertThat(manager.vipStatus(role), is(true));
        manager.pass();
        assertThat(manager.vipStatus(role), is(false));
    }
}
