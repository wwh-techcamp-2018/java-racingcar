package racing;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {
    Car car;

    @Before
    public void setUp() throws Exception {
        car = new Car("car");
    }

    @Test
    public void successMove() {
        assertEquals(1, car.move(5));
    }

    @Test
    public void failMove() {
        assertEquals(0, car.move(2));
    }
}