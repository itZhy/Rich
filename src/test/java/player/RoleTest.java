package player;

import ui.Element;
import org.fusesource.jansi.Ansi;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class RoleTest {
    @Test
    public void it_should_return_blue_when_input_is_babyKin() {
        //when
        Element element = Role.babyKin.getDisplayElement();
        //then
        assertThat(element, is(new Element('B', Ansi.Color.BLUE)));
    }

    @Test
    public void it_should_return_S_with_red_element() {
        //when
        Element element = Role.SunHsiaoMei.dye(new Element('S'));
        //then
        assertThat(element, is(new Element('S', Ansi.Color.RED)));
    }
}
