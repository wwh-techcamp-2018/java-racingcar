package racingcar;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsFactoryTest {

    @Test
    public void 자동차생성() {
        List<RacingCar> cars = RacingCarsFactory.create("pobi,crong,honux");
        assertThat(cars)
                .contains(new RacingCar("pobi"))
                .contains(new RacingCar("crong"))
                .contains(new RacingCar("honux"));
    }
}
