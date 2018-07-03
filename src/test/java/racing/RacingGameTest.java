package racing;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RacingGameTest {

    private RacingGame rg;

    @Before
    public void setUp() throws Exception {
        rg = new RacingGame(3, 3);
    }

    @Test
    public void init() {
        assertEquals(3, rg.carList.size());
    }
}