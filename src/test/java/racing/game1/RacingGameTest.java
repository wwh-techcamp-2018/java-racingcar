package racing.game1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RacingGameTest {
    private Car car;

    @Before
    public void setUp() throws Exception {
        car = new Car();
    }


    @Test
    public void getState() {
        assertEquals("---", car.getState(3));
    }
}