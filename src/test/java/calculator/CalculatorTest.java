package calculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void 계산기테스트() {
        assertEquals(5, Calculator.calculate(2, "+", 3));
    }

    @Test
    public void add() {
        assertEquals(5, Calculator.add(2, 3));
    }

    @Test
    public void minus() {
        assertEquals(-1, Calculator.minus(2, 3));
    }

    @Test
    public void multiply() {
        assertEquals(6, Calculator.multiply(2, 3));
    }

    @Test
    public void divide() {
        assertEquals(2, Calculator.divide(6, 3));
    }

}