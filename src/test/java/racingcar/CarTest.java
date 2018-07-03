package racingcar;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {

    private Car car;

    @Before
    public void setUp() throws Exception {
        car = new Car("포비");
    }

    @Test
    public void carMoveFail() {
        car.move(3);
        assertEquals(0, car.getPosition());
    }

    @Test
    public void carMoveSuccess() {
        car.move(4);
        assertEquals(1, car.getPosition());
    }

    @Test
    public void repeat() {
        car.move(4);
        car.move(5);
        assertEquals("포비 : --", Car.repeat(car.getName(), car.getPosition()));
    }
}