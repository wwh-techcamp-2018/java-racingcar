package racingcar;

import org.junit.Test;

import static org.junit.Assert.*;

public class RacingCarTest {

    @Test
    public void getNewPosition() {
        assertEquals(6, RacingCar.getNewPosition(5, 9));
    }

    @Test
    public void getRoad() {
        assertEquals("---------", RacingCar.getRoad(9));
    }

}