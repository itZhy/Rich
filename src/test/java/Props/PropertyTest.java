package Props;

import Player.UncleTuu;
import UI.Map;
import UI.UIObserver;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PropertyTest {
    private Property property;
    private UIObserver ui;
    private String owner;

    @Before
    public void setUp() {
        property = new Property();
        ui = new Map();
        owner = UncleTuu.class.toString();
    }

    @Test
    public void it_should_be_able_to_afford_barricade() {
        //given
        property.add(50);
        //when
        boolean isSuccessful = property.buy(new Barricade(owner));
        //then
        assertThat(isSuccessful, is(true));
    }

    @Test
    public void it_should_has_machine_doll() {
        //given
        property.add(30);
        property.buy(new MachineDoll(new PropsMap(ui)));
        //when
        boolean isSuccessful = property.consume(new MachineDoll(new PropsMap(ui)));
        //then
        assertThat(isSuccessful, is(true));
    }

    @Test
    public void it_should_not_has_bomb() {
        //given
        property.add(49);
        property.buy(new Bomb(owner));
        //when
        boolean isSuccessful = property.consume(new Bomb(owner));
        //then
        assertThat(isSuccessful, is(false));
    }
}
