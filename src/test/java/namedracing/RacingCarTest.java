package namedracing;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class RacingCarTest {
    RacingCar racingCar;
    Car pobi;
    Car crong;
    Car honux;
    RaceResult raceResult;

    @Before
    public void setUp() {
        racingCar = new RacingCar();
        pobi = new Car("pobi", 0);
        crong = new Car("crong", 1);
        honux = new Car("honux", 5);
        racingCar.cars.add(pobi);
        racingCar.cars.add(crong);
        racingCar.cars.add(honux);
        raceResult = new RaceResult(racingCar.cars);
    }


    @Test
    public void isMovableTest() {
        assertEquals(true,pobi.isMovable(4));
        assertEquals(false, pobi.isMovable(3));
    }

    @Test
    public void moveCarTest() {
        assertEquals(pobi.getPosition() + 1, pobi.moveCar(4));
        assertEquals(pobi.getPosition() + 1, pobi.moveCar(4));

    }

    @Test
    public void generateOutStringTest() {
        assertEquals("crong : -", raceResult.generateOutString(1));
        assertEquals("pobi : ", raceResult.generateOutString(0));
    }

    @Test
    public void checkMaxDistanceTest() {
        raceResult.checkMaxDistance();
        assertEquals(5, raceResult.checkMaxDistance());
    }

}