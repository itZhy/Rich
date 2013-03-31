package ui;

import org.junit.Test;
import player.Position;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PositionExtractorTest {
    @Test
    public void it_should_be_able_to_get_position_list_for_buildings() {
        //given
        PositionExtractor parser = new PositionExtractor();
        //when
        List<Position> positions = parser.getBuildings();
        //then
        assertThat(positions.get(4), is(new Position(5)));
        assertThat(positions.get(16), is(new Position(18)));
        assertThat(positions.get(31), is(new Position(34)));
        assertThat(positions.get(35), is(new Position(39)));
    }
}
