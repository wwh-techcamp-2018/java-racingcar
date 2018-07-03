package racing;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {
    Car car;

    @Before
    public void setup() {
        car = new Car();
    }

    @Test
    public void moveTest() {
        car.move(4);
        assertEquals(1, car.getPosition());
        car.move(1);
        assertEquals(1, car.getPosition());
    }
}