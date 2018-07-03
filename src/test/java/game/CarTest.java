package game;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {
    private Car car;

    @Before
    public void setUp() {
        car = new Car();
    }

    @Test
    public void moveTest() {
        car.movePosition(5);
        assertEquals(0,car.getPosition());
    }
}