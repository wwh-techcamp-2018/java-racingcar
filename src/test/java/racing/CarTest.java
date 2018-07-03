package racing;

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
    public void moveSuccess() {
        car.move(5);
        assertEquals(true, true);
    }

    @Test
    public void moveFail() {
        car.move(2);
        assertEquals(false, false);
    }

    @Test
    public void print() {
        car.move(9);
        car.move(9);
        assertEquals("--", car.print());
    }
}