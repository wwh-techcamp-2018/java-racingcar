package coordinate;

import org.junit.Test;

import static org.junit.Assert.*;

public class PointParserTest {

    @Test
    public void parse() {
        int[] numbers = PointParser.parse("(8,10)");
        assertEquals(8, numbers[0]);
        assertEquals(10, numbers[1]);
    }

    @Test (expected = IllegalArgumentException.class)
    public void parseException() {
        int[] numbers = PointParser.parse("(25,10)");
        assertEquals(8, numbers[0]);
        assertEquals(10, numbers[1]);
    }
}