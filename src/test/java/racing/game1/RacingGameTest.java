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
        cars.add(new Car("pobi"));
        cars.add(new Car("crong"));
        cars.add(new Car("honux"));
        racingGame = new RacingGame();
    }

    @Test
    public void getWinnerWithSingleWinner() {

        for (int i = 0; i < 3; i++) {
            cars.get(i).move(i+2);
        }
        assertEquals("honux가 최종 우승했습니다.",
                RacingGame.getWinner(cars));
    }

    @Test
    public void getWinnerWithCowinner() {
        assertEquals("pobi,crong,honux가 최종 우승했습니다.",
                RacingGame.getWinner(cars));
    }
}