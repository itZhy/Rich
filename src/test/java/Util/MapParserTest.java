package Util;

import Player.Position;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.FileNotFoundException;
import java.util.List;

public class MapParserTest {
    @Test
    public void it_should_be_able_to_get_position_list_for_buildings() {
        try {
            //given
            MapParser parser = new MapParser();
            //when
            List<Position> positions = parser.readDefaultBuilding();
            //then
            assertThat(positions.get(4), is(new Position(5)));
            assertThat(positions.get(16), is(new Position(18)));
            assertThat(positions.get(31), is(new Position(34)));
            assertThat(positions.get(35), is(new Position(39)));
        } catch (FileNotFoundException e) {
            e.toString();
        }
    }
}
