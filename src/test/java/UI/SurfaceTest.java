package UI;

import org.fusesource.jansi.Ansi;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SurfaceTest {
    @Test
    public void it_should_be_able_to_contain_multiple_elements_in_one_index() {
        //given
        Surface surface = new Surface();
        surface.add(3, new Element('A', Ansi.Color.YELLOW));
        //when
        surface.remove(3, new Element('A', Ansi.Color.YELLOW));
        surface.add(4, new Element('A', Ansi.Color.YELLOW));
        //then
        Surface exceptedSurface= new Surface();
        exceptedSurface.add(4, new Element('A', Ansi.Color.YELLOW));
        assertThat(surface, is(exceptedSurface));
    }

}
