package racingcar;

import org.junit.Before;
import org.junit.Test;
import racingcar.controller.RacingGame;
import racingcar.controller.CarFactory;
import racingcar.model.Car;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class RacingGameTest {
    private Car pobi;
    private Car crong;
    private Car hyeona;

    @Before
    public void setUp() throws Exception {
        pobi = new Car("pobi", 0);
        crong = new Car("crong", 1);
        hyeona = new Car("hyeona", 2);
    }

    @Test
    public void createCars() {
        String[] names = {"pobi", "crong", "hyeona"};
        assertThat(CarFactory.createCars(names))
                .contains(new Car("pobi"))
                .contains(new Car("crong"))
                .contains(new Car("hyeona"));
    }

    @Test
    public void getMaxPosition() {
        List<Car> cars = Arrays.asList(pobi, crong, hyeona);
        assertThat(RacingGame.getMaxPosition(cars)).isEqualTo(2);
    }

    @Test
    public void getWinners() {
        List<Car> cars = Arrays.asList(pobi, crong, hyeona);
        assertThat(RacingGame.getWinners(cars))
                .contains(hyeona)
                .doesNotContain(pobi)
                .doesNotContain(crong);
    }


}
