package racingcar;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RacingGameTest {

    private RacingGame rc;

    @Before
    public void setUp() {
        rc = new RacingGame();
    }

    @Test
    public void repeatDash() {
        assertEquals("---", rc.repeatDash(3));
    }
}