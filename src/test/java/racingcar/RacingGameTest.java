package racingcar;

import org.junit.Before;
import org.junit.Test;
import racingcar.random.RandomGenerator;
import racingcar.random.TestRandomGenerator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    private RacingCar pobiCar;
    private RacingCar crongCar;
    private RacingCar honuxCar;

    @Before
    public void setUp() throws Exception {
        pobiCar = new RacingCar("pobi");
        crongCar = new RacingCar("crong");
        honuxCar = new RacingCar("honux");
    }

    @Test
    public void 이동() {
        List<RacingCar> cars = Arrays.asList(pobiCar);
        RandomGenerator randomGenerator = new TestRandomGenerator();

        RacingGame racingGame = new RacingGame(cars, randomGenerator);
        racingGame.moveCars(1);

        assertThat(cars.get(0).getPosition()).isEqualTo(1);

    }

    @Test
    public void 우승자확인() {
        List<RacingCar> cars = Arrays.asList(pobiCar, crongCar, honuxCar);
        RandomGenerator randomGenerator = new TestRandomGenerator();

        RacingGame racingGame = new RacingGame(cars, randomGenerator);
        racingGame.moveCars(1);

        assertThat(RacingGame.makeWinners(cars)).contains(
                new RacingCar("pobi", 1),
                new RacingCar("crong", 1),
                new RacingCar("honux", 1));
    }
}
