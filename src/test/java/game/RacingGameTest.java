package game;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RacingGameTest {

    private RacingGame game;

    @Before
    public void setUp() {
        game = new RacingGame(4);
    }

    @Test
    public void initGame() {
        assertEquals(RacingCar.class, game.getCars().get(1).getClass());
        assertEquals(4, game.getCars().size());
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
//        InputView iv = new InputView();
        ResultView rv = new ResultView();

//        RacingGame game = new RacingGame(iv.getCarNums());
//        game.startGame(iv.getTimes());
        RacingGame game = new RacingGame(10);
        game.startGame(4);

        rv.printResult(game.getCars());
    }
}