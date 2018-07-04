package calculator.old;

import calculator.old.Calculator;
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
        assertEquals(10, cal.plus(3, 7));
    }

    @Test
    public void minus() {
        assertEquals(10, cal.minus(13, 3));
    }

    @Test
    public void multiply() {
        assertEquals(10, cal.multiply(2, 5));
    }

    @Test
    public void divide() {
        assertEquals(10, cal.divide(20, 2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullString() {
        assertEquals(10, cal.calculate(""));
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyString() {
        assertEquals(10, cal.calculate(" "));
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalOperator() {
        assertEquals(10, cal.calculate("3 a 2"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalOperand() {
        assertEquals(10, cal.calculate("a + 2"));
    }
}