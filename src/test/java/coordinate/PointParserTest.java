package coordinate;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PointParserTest {

    @Test
    public void substring(){
        String text = "(8,10)";
        assertEquals("8,10", text.substring(1,text.length() -1));
    }

    @Test
    public void parse(){
        int[] numbers = PointParser.parse("(8,10)");
        int[] expected = new int[]{8,10};
        assertArrayEquals(numbers, expected);
        assertEquals(8, numbers[0]);
        assertEquals(10, numbers[1]);
    }

    @Test (expected = IllegalArgumentException.class)
    public void parse_over_x(){
        int[] numbers = PointParser.parse("(25,10)");
    }

}