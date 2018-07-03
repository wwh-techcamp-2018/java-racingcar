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
    public void operatePlus() {
        assertEquals(5, cal.operate("+", 2, 3));
    }

    @Test
    public void operateMinus() {
        assertEquals(-1, cal.operate("-", 2, 3));
    }

    @Test
    public void operateMultiply() {
        assertEquals(6, cal.operate("*", 2, 3));
    }

    @Test
    public void operateDivide() {
        assertEquals(2, cal.operate("/", 4, 2));
    }

    @Test (expected = ArithmeticException.class)
    public void operateDivideByZero() {
        cal.operate("/", 4, 0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void operateInvalidOperator() {
        cal.operate("!", 2, 3);
    }
}