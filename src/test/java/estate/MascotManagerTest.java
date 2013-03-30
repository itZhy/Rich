package estate;

import player.Role;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MascotManagerTest {
    @Test
    public void it_should_set_vip_when_mascot_coming_and_sustained_five_times() {
        //given
        MascotManager manager = new MascotManager();
        //when
        manager.setMascot(Role.SunHsiaoMei);
        //then
        assertThat(manager.isVip(Role.SunHsiaoMei), is(true));
        manager.update(Role.SunHsiaoMei);
        assertThat(manager.isVip(Role.SunHsiaoMei), is(true));
        manager.update(Role.SunHsiaoMei);
        manager.update(Role.SunHsiaoMei);
        manager.update(Role.SunHsiaoMei);
        assertThat(manager.isVip(Role.SunHsiaoMei), is(true));
        manager.update(Role.SunHsiaoMei);
        assertThat(manager.isVip(Role.SunHsiaoMei), is(false));
    }

    @Test
    public void it_should_set_multiply_vips() {
        MascotManager manager = new MascotManager();
        manager.setMascot(Role.SunHsiaoMei);
        manager.update(Role.SunHsiaoMei);
        manager.setMascot(Role.babyKin);
        manager.update(Role.babyKin);

        manager.update(Role.SunHsiaoMei);
        manager.update(Role.SunHsiaoMei);
        manager.update(Role.babyKin);
        manager.update(Role.babyKin);
        assertThat(manager.isVip(Role.SunHsiaoMei), is(true));
        assertThat(manager.isVip(Role.babyKin), is(true));

        manager.update(Role.SunHsiaoMei);
        manager.update(Role.SunHsiaoMei);
        manager.update(Role.babyKin);
        assertThat(manager.isVip(Role.SunHsiaoMei), is(false));
        assertThat(manager.isVip(Role.babyKin), is(true));
        manager.update(Role.babyKin);
        //then
        assertThat(manager.isVip(Role.babyKin), is(false));
    }
}
