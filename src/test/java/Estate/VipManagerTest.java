package estate;

import player.Callback;
import player.Role;
import player.Player;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class VipManagerTest {
    @Test
    public void it_should_set_vip_when_mascot_coming_and_sustained_five_times() {
        //given
        VipManager manager = new VipManager();
        //when
        Player owner = new Player(Role.SunHsiaoMei, new Callback());
        Role role = owner.role();
        manager.setVip(role);
        //then
        assertThat(manager.isVip(role), is(true));
        manager.pass(Role.SunHsiaoMei);
        assertThat(manager.isVip(role), is(true));
        manager.pass(Role.SunHsiaoMei);
        manager.pass(Role.SunHsiaoMei);
        manager.pass(Role.SunHsiaoMei);
        assertThat(manager.isVip(role), is(true));
        manager.pass(Role.SunHsiaoMei);
        assertThat(manager.isVip(role), is(false));
    }

    @Test
    public void it_should_set_multiply_vips() {
        VipManager manager = new VipManager();
        manager.setVip(Role.SunHsiaoMei);
        manager.pass(Role.SunHsiaoMei);
        manager.setVip(Role.babyKin);
        manager.pass(Role.babyKin);

        manager.pass(Role.SunHsiaoMei);
        manager.pass(Role.SunHsiaoMei);
        manager.pass(Role.babyKin);
        manager.pass(Role.babyKin);
        assertThat(manager.isVip(Role.SunHsiaoMei), is(true));
        assertThat(manager.isVip(Role.babyKin), is(true));

        manager.pass(Role.SunHsiaoMei);
        manager.pass(Role.SunHsiaoMei);
        manager.pass(Role.babyKin);
        assertThat(manager.isVip(Role.SunHsiaoMei), is(false));
        assertThat(manager.isVip(Role.babyKin), is(true));
        manager.pass(Role.babyKin);
        //then
        assertThat(manager.isVip(Role.babyKin), is(false));
    }
}
