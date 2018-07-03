package racing.game1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WinnerTest {

    private Car car;
    private Car standardCar;
    private Winner winner;

    @Before
    public void setUp() throws Exception {
        car = new Car("pobi");
        standardCar = new Car("crong");
        standardCar.move(4);
        standardCar.move(4);
        winner = new Winner();
        winner.changeWinnersStateWithWin(standardCar);
    }

    @Test
    public void isWinFail() {
        winner.changeWinnersStateWithWin(car);
        assertEquals("crong", winner.getWinners().toString());
    }

    @Test
    public void isWinSuccess() {
        car.move(4);
        car.move(4);
        car.move(4);
        winner.changeWinnersStateWithWin(car);
        assertEquals("pobi", winner.getWinners().toString());
    }

    @Test
    public void isDrawFailWithUpperHighScore() {
        car.move(4);
        car.move(4);
        car.move(4);
        winner.changeWinnersStateWithDraw(car);
        assertEquals("crong", winner.getWinners().toString());
    }

    @Test
    public void isDrawFailWithLowerHighScore() {
        winner.changeWinnersStateWithDraw(car);
        assertEquals("crong", winner.getWinners().toString());
    }

    @Test
    public void isDrawSuccess() {
        car.move(4);
        car.move(4);
        winner.changeWinnersStateWithDraw(car);
        assertEquals("crong,pobi", winner.getWinners().toString());
    }

}