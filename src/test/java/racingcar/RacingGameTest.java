package racingcar;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RacingGameTest {
    private RacingGame racingGame;
    private Car car;

    @Before
    public void setUp() throws Exception {
        racingGame = new RacingGame(3, 5);
        car = new Car();
    }

    @Test
    public void moveForwardTest() {
        car.move(5);
        assertEquals(1, car.getPosition());
        car.move(6);
        assertEquals(2, car.getPosition());
        car.move(7);
        assertEquals(3, car.getPosition());
    }

    @Test
    public void stopTest() {
        car.move(1);
        assertEquals(0, car.getPosition());
        car.move(2);
        assertEquals(0, car.getPosition());
        car.move(3);
        assertEquals(0, car.getPosition());
    }
}
