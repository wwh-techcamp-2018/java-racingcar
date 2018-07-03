package racingcar;

import org.junit.Before;
import org.junit.Test;
import util.StringUtil;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class RacingGameTest {
    private RacingGame racingGame;
    private Car car;
    private List<Car> cars;

    @Before
    public void setUp() throws Exception {
        car = new Car(0,"pobi");

    }

    @Test
    public void maxTest() {
        assertEquals(5, RacingGame.getMaxDist(
                Arrays.asList(new Car(3, "car1"), new Car(5, "car2"))));
        assertNotEquals(3, RacingGame.getMaxDist(
                Arrays.asList(new Car(3, "car1"), new Car(5, "car2"))));

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

    @Test
    public void getWinnerTextTest() {
        assertEquals("car1,car2", RacingGame.getWinnerText(
                Arrays.asList(new Car(5, "car1"), new Car(5, "car2"))));
    }

    @Test
    public void getWinnerTest() {
        Car car = new Car(5, "car2");
        assertEquals(Arrays.asList(car), RacingGame.getWinners(
                Arrays.asList(new Car(3, "car1"), car), 5));
    }

}
