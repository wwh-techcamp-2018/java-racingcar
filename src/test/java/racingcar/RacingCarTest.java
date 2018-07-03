package racingcar;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RacingCarTest {

    private RacingCar racingCar;
    private int[] initCarPosition;
    private Car car;

    @Before
    public void setUp() {
        racingCar = new RacingCar();
        initCarPosition = new int[] {0, 3, 5};
        for(int i = 0; i < initCarPosition.length; ++i) {
            racingCar.cars.add(new Car(initCarPosition[i]));
        }
        car = new Car();
    }

    @Test
    public void isMovableTest() {
        assertEquals(true,car.isMovable(4));
        assertEquals(false, car.isMovable(3));
    }

    @Test
    public void moveCarTest() {
        assertEquals(car.position + 1, car.moveCar());
        assertEquals(car.position + 1, car.moveCar());

    }

    @Test
    public void generateOutStringTest() {
        assertEquals("---", racingCar.generateOutString(1));
        assertEquals("", racingCar.generateOutString(0));
    }
}