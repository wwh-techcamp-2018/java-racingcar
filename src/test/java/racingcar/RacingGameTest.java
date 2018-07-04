package racingcar;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RacingGameTest {

    private RacingGame game;

    @Before
    public void setUp() throws Exception {
        game = new RacingGame();
    }

    @Test (expected = IllegalArgumentException.class)
    public void setNullCarNames() {
        game.setCarNames(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void setEmptyCarNames() {
        game.setCarNames("");
    }

    @Test (expected = RuntimeException.class)
    public void runWithoutCars() {
        game.run(1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void runZeroTime() {
        game.setCarNames("testCar");
        game.run(0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void runNegativeTimes() {
        game.setCarNames("testCar");
        game.run(-1);
    }

}