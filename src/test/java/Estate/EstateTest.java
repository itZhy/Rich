package Estate;

import Player.*;
import UI.Map;
import UI.UIObserver;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class EstateTest {
    @Test
    public void it_should_check_field_is_vacant() {
        //given
        UIObserver ui = new Map();
        Estate estate = new Estate(ui);
        Building vacancy = new Vacancy(null, ui);
        //when
        boolean result = estate.checkSoldStatus(vacancy);
        //then
        assertThat(result, is(false));
    }

    @Test
    public void it_should_check_field_is_not_vacant() {
        //given
        UIObserver ui = new Map();
        Callback callback = new Callback();
        Estate estate = new Estate(ui);
        Role role = new MadameChyan(ui, callback);
        Building skyscraper = new Skyscraper(role.getClass().toString(), ui);
        //when
        boolean result = estate.checkSoldStatus(skyscraper);
        //then
        assertThat(result, is(true));
    }
}
