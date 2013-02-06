package UI;

import Player.Position;
import org.fusesource.jansi.Ansi;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MapTest {
    @Test
    public void it_should_be_able_to_contain_multiple_elements_in_one_position()    {
        //given
        Map map = new Map();
        map.add(new Position(3), new Element('A', Ansi.Color.YELLOW));
        //when
        map.remove(new Position(3), new Element('A', Ansi.Color.YELLOW));
        map.add(new Position(4), new Element('A', Ansi.Color.YELLOW));
        //then
        Map exceptedMap = new Map();
        exceptedMap.add(new Position(4), new Element('A', Ansi.Color.YELLOW));
        assertThat(map, is(exceptedMap));
    }
}
