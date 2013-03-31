package estate;

import org.junit.Test;
import player.Position;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PriceExtractorTest {
    @Test
    public void it_should_get_price_of_building_by_position() {
        //given
        PriceExtractor extractor = new PriceExtractor();
        //then
        assertThat(extractor.priceOfPosition(new Position(3)), is(new Money(200.)));
        assertThat(extractor.priceOfPosition(new Position(32)), is(new Money(500.)));
        assertThat(extractor.priceOfPosition(new Position(37)), is(new Money(300.)));
    }
}
