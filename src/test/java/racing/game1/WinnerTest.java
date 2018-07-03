package racing.game1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WinnerTest {

    private Car car;
    private Winner winner;

    @Before
    public void setUp() throws Exception {
        car = new Car("pobi");
        winner = new Winner();
    }

    @Test
    public void isWinFail() {
        car.setPosition(-1);
        winner.isWin(car);
        assertEquals("", winner.getWinners().toString());
    }

    @Test
    public void isWinSuccess() {
        car.setPosition(0);
        winner.isWin(car);
        assertEquals("pobi", winner.getWinners().toString());
    }

    @Test
    public void isDrawFailWithUpperHighScore() {
        car.setPosition(0);
        winner.isDraw(car);
        assertEquals("", winner.getWinners().toString());
    }

    @Test
    public void isDrawFailWithLowerHighScore() {
        car.setPosition(-2);
        winner.isDraw(car);
        assertEquals("", winner.getWinners().toString());
    }

    @Test
    public void isDrawSuccess() {
        car.setPosition(-1);
        winner.isDraw(car);
        assertEquals(",pobi", winner.getWinners().toString());
    }

}