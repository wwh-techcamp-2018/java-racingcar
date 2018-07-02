package calculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {


    private Calculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void calculate() {
        assertEquals(10, calculator.calculate("2 + 3 * 4 / 2"));
    }

    @Test
    public void minusOnly() {
        assertEquals(2, calculator.calculate("4 - 1 - 1"));
    }

    @Test
    public void plusOnly() {
        assertEquals(3, calculator.calculate("1 + 1 + 1"));
    }

    @Test
    public void multiplyOnly() {
        assertEquals(8, calculator.calculate("2 * 2 * 2"));
    }

    @Test
    public void divideOnly() {
        assertEquals(2, calculator.calculate("8 / 2 / 2"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void unexpectedOperatorHead() {
        calculator.calculate("- 8 + 8");
    }

    @Test(expected = IllegalArgumentException.class)
    public void unexpectedOperatorTail() {
        calculator.calculate("8 + 1 -");
    }

    @Test(expected = IllegalArgumentException.class)
    public void inputNull() {
        calculator.calculate(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void inputEmptyString() {
        calculator.calculate("");
    }
}