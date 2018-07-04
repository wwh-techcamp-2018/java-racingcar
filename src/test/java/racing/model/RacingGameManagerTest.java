package racing.model;

import org.junit.Before;
import org.junit.Test;
import racing.model.Car;
import racing.model.RacingGameManager;
import racing.model.RandomValueGenerator;
import racing.model.ValueGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class RacingGameManagerTest {
    private RacingGameManager racingGameManager;
    private ValueGenerator valueGenerator;
    private String[] names;

    @Before
    public void setUp() throws Exception {
        names = new String[]{"pobi", "crong", "honux"};
        valueGenerator = new RandomValueGenerator();
    }

    @Test
    public void judgeWinnerTest() {
        racingGameManager = new RacingGameManager(names, valueGenerator);

        Car car = new Car("pobi");
        assertThat(racingGameManager.judgeWinner(car, 1)).isEqualTo(false);

        car.move(5);
        assertThat(racingGameManager.judgeWinner(car, 1)).isEqualTo(true);
    }

    @Test
    public void addWinners() {
        Car honux = new Car("honux", 6);
        Car crong = new Car("crong", 6);
        Car pobi = new Car("pobi", 5);
        List<Car> cars = new ArrayList<>();
        cars = Arrays.asList(honux, crong, pobi);

        racingGameManager = new RacingGameManager(cars);

        GameResult gameResult = new GameResult();
        assertThat(racingGameManager.addWinners(gameResult))
                .contains(honux)
                .contains(crong)
                .doesNotContain(pobi);
    }
}