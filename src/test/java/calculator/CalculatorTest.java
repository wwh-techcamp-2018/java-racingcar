package calculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator cal;

    @Before
    public void setUp() throws Exception {

        cal = new Calculator();
    }

    @Test
    public void plus() {
        int result = cal.plus(2, 4);
        assertEquals(5, result);
    }

    @Test
    public void minus() {
        Calculator cal = new Calculator();
        int result = cal.minus(2, 4);
        assertEquals(-2, result);
    }

    @Test
    public void parseResult() {
        int result = cal.parseResult("2 + 3 * 4 / 2");
        assertEquals(10, result);
    }
}