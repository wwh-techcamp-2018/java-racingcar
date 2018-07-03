package racing;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RacingGameTest {

    private RacingGame rg;

    @Before
    public void setUp() throws Exception {

        rg = new RacingGame();
    }

    @Test
    public void init() {
        rg.setCarNum(3);
        assertEquals(3, rg.carList.size());
    }
}