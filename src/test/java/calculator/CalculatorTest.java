package calculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calc;

    @Before
    public void setUp() throws Exception {
        calc = new Calculator();
    }

    @Test
    public void plus() {
        assertEquals(5, calc.plus(2, 3));
    }

    @Test
    public void minus() {
        assertEquals(-1, calc.minus(2, 3));
    }


    @Test
    public void calcData() {
        int result = calc.calcData("2 + 3 * 4 / 2");
        assertEquals(10, result);
    }
}