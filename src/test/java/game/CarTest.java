package game;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {
    private Car car;

    @Before
    public void setUp() {
        car = new Car("혁진");
    }

    @Test
    public void movedSucceedTest() {
        car.movePosition(5);
        assertEquals(0, car.getPosition());
    }

    @Test
    public void movedFailedTest() {
        car.movePosition(2);
        assertEquals(0, car.getPosition());
    }

    @Test
    public void bigPositionTest() {
        car.movePosition(5);
        assertEquals(2, car.findBiggerPosition(2));
    }

    @Test
    public void isReachedTest() {
        car.movePosition(5);
        car.movePosition(4);
        car.movePosition(3);
        assertEquals(true, car.isReached(2));
    }
}