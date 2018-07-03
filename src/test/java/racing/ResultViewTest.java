package racing;

import org.junit.Test;

import static org.junit.Assert.*;

public class ResultViewTest {
    @Test
    public void getPositionString() {
        assertEquals("---", ResultView.getPositionString(3));
    }
}