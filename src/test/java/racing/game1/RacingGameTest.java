package racing.game1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RacingGameTest {

    private RacingGame racingGame;
    private List<Car> cars;
    @Before
    public void setUp() throws Exception {
        cars = new ArrayList<Car>();
        cars.add(new Car("pobi",3));
        racingGame = new RacingGame(new String[]{""});
    }

    @Test
    public void getWinnerWithSingleWinner() {
        cars.add(new Car("crong"));
        cars.add(new Car("honux"));
        assertEquals("pobi",
                RacingGame.getWinner(cars));
    }

    @Test
    public void getWinnerWithCowinner() {
        cars.add(new Car("crong",3));
        cars.add(new Car("honux",3));
        assertEquals("pobi,crong,honux",
                RacingGame.getWinner(cars));
    }
}