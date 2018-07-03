package racingcar;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RacingCarGameTest {

    private RacingCarGame game;

    @Before
    public void setUp() throws Exception {
        game = new RacingCarGame(5);
    }
}