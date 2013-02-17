package Player;

import Player.BabyKin;
import Player.RoleColor;
import Player.SunHsiaoMei;
import UI.Element;
import org.fusesource.jansi.Ansi;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class RoleColorTest {
    @Test
    public void it_should_return_blue_when_input_is_babyKin() {
        //given
        RoleColor roleColor = new RoleColor();
        //when
        Ansi.Color color = roleColor.get(BabyKin.class.toString());
        //then
        assertThat(color, is(Ansi.Color.BLUE));
    }

    @Test
    public void it_should_return_S_with_red_element() {
        //given
        RoleColor roleColor = new RoleColor();
        //when
        Element element = roleColor.dye(SunHsiaoMei.class.toString(), 'S');
        //then
        assertThat(element, is(new Element('S', Ansi.Color.RED)));
    }
}
