package game;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RacingGameTest {

    private RacingGame game;

    @Before
    public void setUp() {
        game = new RacingGame(4);
    }

    @Test
    public void initGame() {
        assertEquals(RacingCar.class, game.getCarList().get(1).getClass());
        assertEquals(4, game.getCarList().size());
    }

    @Test
    public void moveCar() {
        RacingCar car = new RacingCar();
        car.moveForward(5);
        assertEquals(car.getPosition(), 1);
    }

    @Test
    public void randomNum() {
        assertEquals(true, game.getRandomNum() < 10);
        assertEquals(true, game.getRandomNum() >= 0);
    }

    @Test
    public void start() {
        ArrayList<Integer> result = game.startGame(5);
        game.printResult(result);
    }
}