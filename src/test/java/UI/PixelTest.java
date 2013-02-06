package UI;

import org.fusesource.jansi.Ansi;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PixelTest {
    @Test
    public void it_should_be_able_to_contain_multiple_elements_in_one_position() {
        //given
        Pixel pixel = new Pixel();
        pixel.add(new Element('A', Ansi.Color.YELLOW));
        pixel.add(new Element('S', Ansi.Color.RED));
        //when
        pixel.remove(new Element('A', Ansi.Color.YELLOW));
        //then
        Pixel exceptedPixel = new Pixel();
        exceptedPixel.add(new Element('S', Ansi.Color.RED));
        assertThat(pixel, is(exceptedPixel));
    }
}
