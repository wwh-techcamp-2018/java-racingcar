package racingcar;


import org.junit.Test;

import java.util.Arrays;

public class RacingCarsTest {

    @Test (expected = NullPointerException.class)
    public void nullCars() {
        new RacingCars(null);
    }

    @Test (expected = RuntimeException.class)
    public void emptyCars() {
        new RacingCars(Arrays.asList());
    }

}