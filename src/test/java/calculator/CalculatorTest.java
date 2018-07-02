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
    public void add() {
        int result = cal.add(4, 4);
        assertEquals(8, result);
    }

    @Test
    public void sub() {
        Calculator cal = new Calculator();
        int result = cal.sub(5, 3);
        assertEquals(2, result);
    }
}