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

    @Before
    public void setUp() {
        racingCar = new RacingCar();
        pobi = new Car("pobi", 0);
        crong = new Car("crong", 1);
        honux = new Car("honux", 5);
        racingCar.cars.add(pobi);
        racingCar.cars.add(crong);
        racingCar.cars.add(honux);

    }

    @Test
    public void checkWinnerTest() {
        for(int i = 0; i < racingCar.cars.size(); i++) {
            racingCar.checkWinner(i);
        }

        assertEquals("honux", racingCar.winners.get(0).name);
    }

    @Test
    public void isMovableTest() {
        assertEquals(true,pobi.isMovable(4));
        assertEquals(false, pobi.isMovable(3));
    }

    @Test
    public void moveCarTest() {
        assertEquals(pobi.position + 1, pobi.moveCar());
        assertEquals(pobi.position + 1, pobi.moveCar());

    }

    @Test
    public void generateOutStringTest() {
        assertEquals("crong : -", racingCar.generateOutString(1));
        assertEquals("pobi : ", racingCar.generateOutString(0));
    }

}