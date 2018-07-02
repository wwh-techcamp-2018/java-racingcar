package stringCalculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalculatorTest {

    private StringCalculator sc;

    @Before
    public void setUp() throws Exception {
        sc = new StringCalculator();
    }

    @Test
    public void calculate() {
        assertEquals(10, sc.calculate("2 + 3 * 4 / 2"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void calculateEmptyInput() {
        sc.calculate("");
    }

    @Test (expected = IllegalArgumentException.class)
    public void calculateNullInput() {
        sc.calculate(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void calculateInvalidOperand() {
        sc.calculate("a + b");
    }

    @Test (expected = IllegalArgumentException.class)
    public void calculateInvalidOperator() {
        sc.calculate("1 ! 2");
    }
}