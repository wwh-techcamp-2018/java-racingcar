package calculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void calculate() {
        assertEquals(10, new Calculator().calculate("2 + 3 * 4 / 2"));
    }
}