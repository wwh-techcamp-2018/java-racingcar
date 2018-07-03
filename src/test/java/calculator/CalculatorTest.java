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

    @Test(expected = IllegalArgumentException.class)
    public void plusTest() {
        assertEquals(5, calculator.plus(2, 3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void missionTest() {
        assertEquals(11, calculator.stringToCalculate("2 + 3 * 4 / 2"));
    }
}