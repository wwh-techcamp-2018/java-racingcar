package racing;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {
    Car car;

    @Before
    public void setup() {
        car = new Car("porbi");
    }

    @Test
    public void goTest() {
        car.move(4);
        assertEquals(1, car.getPosition());
    }

    @Test
    public void stopTest() {
        car.move(1);
        assertEquals(0, car.getPosition());
    }
}