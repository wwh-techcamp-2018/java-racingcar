package racing;

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
    public void moveSuccess() {
        assertEquals(true, car.move(9));
    }

    @Test
    public void moveFail() {
        assertEquals(false, car.move(0));
    }

    @Test
    public void print() {
        car.move(9);
        car.move(9);
        assertEquals("--", car.print());
    }
}