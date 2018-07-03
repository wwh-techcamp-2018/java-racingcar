package racingcar;

import org.junit.Before;
import org.junit.Test;
import util.StringUtil;

import java.util.List;

import static org.junit.Assert.*;

public class RacingGameTest {
    private RacingGame racingGame;
    private Car car;
    private List<Car> cars;

    @Before
    public void setUp() throws Exception {
        racingGame = new RacingGame(StringUtil.parseName(""), 5);
        car = new Car(0,"pobi");
        racingGame.addNewCar(new Car(3, "car1"));
        racingGame.addNewCar(new Car(5, "car2"));
        racingGame.addNewCar(new Car(5, "car3"));
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
    public void getWinnerTest() {
        assertEquals("car2,car3", racingGame.getWinnerText(racingGame.getWinners(racingGame.getMaxDist())));
    }

    @Test
    public void getMaxDistTest() {
        assertEquals(5, racingGame.getMaxDist());
    }
}
