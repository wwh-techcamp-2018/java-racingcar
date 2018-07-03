package racing;

import org.junit.Test;

import static org.junit.Assert.*;

public class RacingTest {
    @Test
    public void buildDashTest() {
        assertEquals("-----", Racing.buildDash(5));
    }
}