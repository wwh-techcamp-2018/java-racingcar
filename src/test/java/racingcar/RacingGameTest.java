package racingcar;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RacingGameTest {
    private RacingGame racingGame;

    @Before
    public void setUp() throws Exception {
        racingGame = new RacingGame(3, 5);
    }

    @Test
    public void moveTest() {
        racingGame.move(5, 0);
        assertEquals(1, racingGame.getCarPositions()[0]);
        racingGame.move(6, 0);
        assertEquals(2, racingGame.getCarPositions()[0]);
        racingGame.move(3, 0);
        assertEquals(2, racingGame.getCarPositions()[0]);
    }

    @Test
    public void repeatTest() {
        assertEquals("", racingGame.repeat(0));
        assertEquals("-", racingGame.repeat(1));
        assertEquals("--", racingGame.repeat(2));
        assertEquals("---", racingGame.repeat(3));
    }
}
