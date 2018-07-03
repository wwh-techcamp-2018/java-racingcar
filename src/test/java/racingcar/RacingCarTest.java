package racingcar;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RacingCarTest {

    private RacingCar racingCar;
    private int[] initCarPostion;

    @Before
    public void setUp() {
        racingCar = new RacingCar();
        initCarPostion = new int[] {0, 3, 5};
        racingCar.setCars(initCarPostion);
    }

    @Test
    public void isMovableTest() {
        assertEquals(true, racingCar.isMovable(4));
        assertEquals(false, racingCar.isMovable(3));
    }

    @Test
    public void moveCarTest() {
        assertEquals(racingCar.getCars()[0] + 1, racingCar.moveCar(0));
        assertEquals(racingCar.getCars()[1] + 1, racingCar.moveCar(1));

    }

    @Test
    public void generateOutStringTest() {
        assertEquals("---", racingCar.generateOutString(1));
        assertEquals("", racingCar.generateOutString(0));
    }
}