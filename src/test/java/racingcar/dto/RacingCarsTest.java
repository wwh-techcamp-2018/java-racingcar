package racingcar.dto;

import org.junit.Test;
import racingcar.domain.Car;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {

    @Test (expected = NullPointerException.class)
    public void nullCars() {
        new RacingCars(null);
    }

    @Test (expected = RuntimeException.class)
    public void emptyCars() {
        new RacingCars(Arrays.asList());
    }

    @Test
    public void getWinnerCars() {
        RacingCars racingCars = new RacingCars(Arrays.asList(new Car("a", 1), new Car("b", 2)));
        racingCars.setMaxPosition(2);
        assertThat(racingCars.getWinnerCars()).contains(new Car("b", 2));
    }

}