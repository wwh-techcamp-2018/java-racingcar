package racing.game1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RacingGameTest {
    private RacingGame racingGame;

    @Before
    public void setUp() throws Exception {
        racingGame = new RacingGame();
    }

    @Test
    public void move() {
        assertEquals(1, racingGame.move(5));
    }

    @Test
    public void rep() {
        assertEquals(3, racingGame.forward(2, 1));
    }

    @Test
    public void getState() {
        assertEquals("---", racingGame.changeState(3));
    }
}