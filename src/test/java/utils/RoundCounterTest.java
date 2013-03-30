package utils;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RoundCounterTest {
    @Test
    public void it_should_not_exceed_after_one_round() {
        //given
        RoundCounter roundCounter = new RoundCounter();
        roundCounter.setMaxCount(1);
        //when
        roundCounter.pass();
        //then
        assertThat(roundCounter.isExceed(), is(false));
    }

    @Test
    public void it_should_exceed_after_two_round() {
        //given
        RoundCounter roundCounter = new RoundCounter();
        roundCounter.setMaxCount(1);
        //when
        roundCounter.pass();
        roundCounter.pass();
        //then
        assertThat(roundCounter.isExceed(), is(true));
    }
}
