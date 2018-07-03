package game;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class RacingGameTest {

    private RacingGame game;

    @Before
    public void setUp() {
        game = new RacingGame(new String[]{"pobi", "crong", "honux"});
    }

    @Test
    public void initGame() {
        assertEquals(RacingCar.class, game.getCars().get(1).getClass());
        assertEquals(3, game.getCars().size());
    }


    @Test
    public void moveCar() {
        String name = "pobi";
        RacingCar car = new RacingCar(name);
        assertEquals(name, car.getName());
        car.moveForward(5);
        assertEquals(car.getPosition(), 1);
    }

    @Test
    public void randomNum() {
        assertTrue(game.getRandomNum() < 10);
        assertTrue(game.getRandomNum() >= 0);
    }

    @Test
    public void maxPosition() {
        List<RacingCar> cars = game.getCars();
        cars.get(0).moveForward(10);
        cars.get(1).moveForward(10);
        cars.get(2).moveForward(10);
        cars.get(2).moveForward(10);
        assertEquals(2, game.getMaxPosition(cars));
    }

    @Test
    public void getWinner() {
        List<RacingCar> cars = game.getCars();
        cars.get(0).moveForward(10);
        cars.get(1).moveForward(10);
        cars.get(2).moveForward(10);
        cars.get(2).moveForward(10);

        Set<String> set = new HashSet<>();
        set.add(cars.get(2).getName());
        assertEquals(set, game.getWinners());

    }

    @Test
    public void start() {
//        InputView iv = new InputView();
        ResultView rv = new ResultView();

//        RacingGame game = new RacingGame(iv.getNames());
//        game.startGame(iv.getTimes());
        RacingGame game = new RacingGame(new String[]{"pobi", "crong", "honux"});
        game.startGame(4);

        rv.printResult(game);
    }
}