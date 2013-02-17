package Player;

import UI.Element;
import org.fusesource.jansi.Ansi;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FeatureTest {
    @Test
    public void it_should_return_blue_when_input_is_babyKin() {
        //given
        Feature feature = new Feature();
        //when
        Element element = feature.get(BabyKin.class.toString());
        //then
        assertThat(element, is(new Element('B', Ansi.Color.BLUE)));
    }

    @Test
    public void it_should_return_S_with_red_element() {
        //given
        Feature feature = new Feature();
        //when
        Element element = feature.dye(SunHsiaoMei.class.toString(), 'S');
        //then
        assertThat(element, is(new Element('S', Ansi.Color.RED)));
    }
}
