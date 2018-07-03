package racingcar;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {

    private Car car;

    @Before
    public void setUp() throws Exception {
        car = new Car();
    }

    @Test
    public void carMoveFail() {
        car.move(0);
        assertEquals(0, car.getPosition());
    }

    @Test
    public void carMoveSuccess() {
        car.move(8);
        assertEquals(1, car.getPosition());
    }

    @Test
    public void repeat() {
        car.move(6);
        car.move(7);
        car.move(1);
        assertEquals("--",car.repeat());
    }
}