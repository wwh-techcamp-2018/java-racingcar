package racingcar;

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
    public void getRoad() {
        assertEquals("---------", RacingGame.getRoad(9));
    }

}