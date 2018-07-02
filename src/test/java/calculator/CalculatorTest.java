package calculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void parse() {
        String[] arr = Calculator.parse("2 + 3 * 4");
        assertEquals(arr[0],"2");
        assertEquals(arr[1],"+");
        assertEquals(arr[2],"3");
        assertEquals(arr[3],"*");
        assertEquals(arr[4],"4");
    }
}