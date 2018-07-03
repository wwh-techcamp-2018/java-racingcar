package car;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class CarTest {

    Car car;

    @Before
    public void setUp() {
        car = new Car();
    }

    @Test
    public void moveACar움직이지않는경우() {
        assertEquals(0, car.move(3));
    }

    @Test
    public void moveACar움직이는경우() {
        assertEquals(1, car.move(4));
    }

}
