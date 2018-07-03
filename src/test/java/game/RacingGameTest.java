package game;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RacingGameTest {
    private RacingGame racingGame;

    @Before
    public void setUp() {
        racingGame = new RacingGame();
    }

    @Test
    public void dashTest() {
        assertEquals("---", racingGame.dashString(3));
    }
}