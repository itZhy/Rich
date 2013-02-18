package Prop;

import Player.UncleTuu;
import UI.Map;
import UI.UIException;
import UI.UIObserver;
import org.junit.Before;
import org.junit.Test;

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
        property.buy(new Barricade(owner));
    }

    @Test
    public void it_should_has_machine_doll() {
        //given
        property.add(30);
        property.buy(new Robot());
        //when
        property.consume(new Robot());
    }

    @Test (expected = UIException.class)
    public void it_should_not_has_bomb() {
        //given
        property.add(49);
        property.buy(new Bomb(owner));
        //when
        property.consume(new Bomb(owner));
    }
}
