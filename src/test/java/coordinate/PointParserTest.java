package coordinate;

import org.junit.Test;

import static org.junit.Assert.*;

public class PointParserTest {


    @Test
    public void substring() {
        String text = "(8,10)";
        assertEquals("8,10",text.substring(1,text.length()-1));
    }

    @Test
    public void parse() {
        int[] numbers = PointParser.parse("(8,10)");
        assertEquals(8,numbers[0]);
        assertEquals(10,numbers[1]);
    }

    @Test (expected = IllegalArgumentException.class)
    public void parseException() {
        int[] numbers = PointParser.parse("(8,25)");
        assertEquals(8,numbers[0]);
        assertEquals(8,numbers[1]);
    }
}