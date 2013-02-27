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
        assertThat(manager.isVip(role), is(true));
        manager.pass(Feature.SUN_HSIAO_MEI);
        assertThat(manager.isVip(role), is(true));
        manager.pass(Feature.SUN_HSIAO_MEI);
        manager.pass(Feature.SUN_HSIAO_MEI);
        manager.pass(Feature.SUN_HSIAO_MEI);
        assertThat(manager.isVip(role), is(true));
        manager.pass(Feature.SUN_HSIAO_MEI);
        assertThat(manager.isVip(role), is(false));
    }

    @Test
    public void it_should_set_multiply_vips() {
        VipManager manager = new VipManager();
        manager.setVip(Feature.SUN_HSIAO_MEI);
        manager.pass(Feature.SUN_HSIAO_MEI);
        manager.setVip(Feature.BABY_KIN);
        manager.pass(Feature.BABY_KIN);

        manager.pass(Feature.SUN_HSIAO_MEI);
        manager.pass(Feature.SUN_HSIAO_MEI);
        manager.pass(Feature.BABY_KIN);
        manager.pass(Feature.BABY_KIN);
        assertThat(manager.isVip(Feature.SUN_HSIAO_MEI), is(true));
        assertThat(manager.isVip(Feature.BABY_KIN), is(true));

        manager.pass(Feature.SUN_HSIAO_MEI);
        manager.pass(Feature.SUN_HSIAO_MEI);
        manager.pass(Feature.BABY_KIN);
        assertThat(manager.isVip(Feature.SUN_HSIAO_MEI), is(false));
        assertThat(manager.isVip(Feature.BABY_KIN), is(true));
        manager.pass(Feature.BABY_KIN);
        //then
        assertThat(manager.isVip(Feature.BABY_KIN), is(false));
    }
}
