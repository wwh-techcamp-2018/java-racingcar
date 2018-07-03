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
        racingGame.move();
        assertArrayEquals(new int[]{5, 5, 5}, racingGame.getCarPositions());
    }

    @Test
    public void failMove() {
        racingGame.setValueGenerator(new StaticValueGenerator(3));
        racingGame.move();
        assertArrayEquals(new int[]{0, 0, 0}, racingGame.getCarPositions());
    }

    @Test
    public void moveCars() {
        racingGame.moveCars(new int[]{4, 3, 9});
        assertArrayEquals(new int[]{1, 0, 1}, racingGame.getCarPositions());
    }

    @Test
    public void singleWinnerTest() {
        racingGame.moveCars(new int[]{2, 3, 9});
        assertEquals("honux", racingGame.judgeWinners()[0]);
    }

    @Test
    public void multiWinnerTest() {
        racingGame.moveCars(new int[]{2, 5, 5});
        assertArrayEquals(new String[]{"crong", "honux"}, racingGame.judgeWinners());
    }

}