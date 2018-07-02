package coordinate;

import org.junit.Test;

import static org.junit.Assert.*;

public class PointParserTest {

    @Test
    public void substring(){
        String text = "(8,10)";
        assertEquals("8,10", text.substring(1, text.length() - 1));
    }

    @Test
    public void parse() {
        int[] numbers = PointParser.parse("(1,2)");
        assertEquals(1, numbers[0]);
        assertEquals(2, numbers[1]);
    }

    @Test (expected = IllegalArgumentException.class)
    public void parse_isvalid_coordinate_value() {
        int[] numbers = PointParser.parse("(1,2)");
        assertEquals(1, numbers[0]);
        assertEquals(2, numbers[1]);
    }
}