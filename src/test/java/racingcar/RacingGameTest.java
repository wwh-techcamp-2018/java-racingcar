package racingcar;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    private RacingGame game;

    @Before
    public void setUp() throws Exception {
        game = new RacingGame("a,b,c,d");
    }

    @Test (expected = IllegalArgumentException.class)
    public void setEmptyCarNames() {
        new RacingGame("");
    }
//
//    @Test (expected = RuntimeException.class)
//    public void runWithoutCars() {
//        game.run(1);
//    }

    @Test (expected = IllegalArgumentException.class)
    public void runLessThanOnce() {
        game.run(0);
    }

    @Test
    public void getWinners() {
        List<Car> carList = Arrays.asList(new Car("a", 1)
        , new Car("b", 2));
        RacingCars racingCars = new RacingCars(carList);
        racingCars.setMaxPosition(2);
        RacingGame racingGame = new RacingGame(racingCars);

        assertThat(racingGame.getWinners()).contains(new Car("b", 2));
    }
}