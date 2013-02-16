package Estate;

import Player.BabyKin;
import Player.Position;
import Player.Role;
import UI.Map;
import UI.UIObserver;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class OperationTest {
    @Test
    public void it_should_check_field_is_vacant() {
        //given
        UIObserver ui = new Map();
        Operation operation = new Operation(ui);
        Building vacancy = new Vacancy(null, ui);
        //when
        boolean result = operation.checkSoldStatus(vacancy);
        //then
        assertThat(result, is(false));
    }

    @Test
    public void it_should_check_field_is_not_vacant() {
        //given
        UIObserver ui = new Map();
        Estate estate = new Estate(ui);
        Operation operation = new Operation(ui);
        Role babyKin = new BabyKin(new Position(0), ui, estate);
        Building skyscraper = new Skyscraper(babyKin, ui);
        //when
        boolean result = operation.checkSoldStatus(skyscraper);
        //then
        assertThat(result, is(true));
    }
}
