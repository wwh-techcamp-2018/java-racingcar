package racing.game1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {

    private Car car;

    @Before
    public void setUp() throws Exception {
        car = new Car("pobi");
    }

    @Test
    public void moveFail() {
        car.move(3);
        assertEquals(0, car.getPosition());
    }

    @Test
    public void moveSuccess() {
        car.move(4);
        assertEquals(1, car.getPosition());
    }

    @Test
    public void getState() {
        assertEquals("---", Car.getState(3));
    }

}