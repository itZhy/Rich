package ui;

import player.Position;
import org.fusesource.jansi.Ansi;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MapTest {
    @Test
    public void it_should_be_able_to_move_element_form_source_to_destination()    {
        //given
        Map map = new Map();
        map.add(new Position(3), new Element('A', Ansi.Color.YELLOW));
        //when
        map.move(new Position(3), new Position(4), new Element('A', Ansi.Color.YELLOW));
        //then
        Map exceptedMap = new Map();
        exceptedMap.add(new Position(4), new Element('A', Ansi.Color.YELLOW));
        assertThat(map, is(exceptedMap));
    }
}
