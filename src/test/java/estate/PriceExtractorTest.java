package estate;

import player.Position;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PriceExtractorTest {
    @Test
    public void it_should_get_price_of_building_by_position(){
        //given
        PriceExtractor extractor = new PriceExtractor();
        //then
        assertThat(extractor.priceOfPosition(new Position(3)), is(200));
        assertThat(extractor.priceOfPosition(new Position(32)), is(500));
        assertThat(extractor.priceOfPosition(new Position(37)), is(300));
    }
}