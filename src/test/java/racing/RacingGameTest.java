package racing;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RacingGameTest {
    RacingGame racingGame;

    @Before
    public void setUp() {
        racingGame = new RacingGame("pobi,crong,honux", 5);
    }

    @Test
    public void successMove() {
        racingGame.setValueGenerator(new StaticValueGenerator(5));
        assertArrayEquals(new int[]{5, 5, 5}, racingGame.play().stream().mapToInt(Car::getPosition).toArray());
    }

    @Test
    public void failMove() {
        racingGame.setValueGenerator(new StaticValueGenerator(3));
        assertArrayEquals(new int[]{0, 0, 0}, racingGame.play().stream().mapToInt(Car::getPosition).toArray());
    }

    @Test
    public void singleWinnerTest() {
        assertEquals("honux", ResultView.judgeWinners(racingGame.moveCars(new int[]{2, 3, 9}))[0]);
    }

    @Test
    public void multiWinnerTest() {
        assertArrayEquals(new String[]{"crong", "honux"}, ResultView.judgeWinners(racingGame.moveCars(new int[]{2, 5, 5})));
    }



}