package utils;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RoundCounterTest {
    @Test
    public void it_should_not_exceed_for_a_new_rounder_counter() {
        //given
        RoundCounter roundCounter = new RoundCounter();
        //then
        assertThat(roundCounter.isExceed(), is(true));
    }

    @Test
    public void it_should_exceed_after_one_round() {
        //given
        RoundCounter roundCounter = new RoundCounter();
        //when
        roundCounter.setMaxCount(1);
        //then
        assertThat(roundCounter.isExceed(), is(false));
        //when
        roundCounter.pass();
        //then
        assertThat(roundCounter.isExceed(), is(true));
    }
}
