package coordinate;

import org.junit.Test;

import static org.junit.Assert.*;

public class PointParserTest {

    @Test
    public void subString() {
        String text = "(8,10)";
        assertEquals("8,10", text.substring(1, text.length()-1));
    }

    @Test
    public void parse() {
        int[] values = PointParser.parse("(8,3)");
        assertEquals(8, values[0]);
        assertEquals(3, values[1]);
    }
}