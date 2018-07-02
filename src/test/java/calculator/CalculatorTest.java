package calculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator cal;


    //executed again for each tests
    //for initialization and independence
    @Before
    public void setUp() throws Exception {
        cal = new Calculator();
    }

    //executed randomly.
    //no dependency guaranteed
    @Test
    public void plusTest() {
        int result = cal.plus(2,3);
        assertEquals(5, result);
    }

    @Test
    public void minusTest() {
        int result = cal.minus(2,3);
        assertEquals(-1, result);
    }

    @Test
    public void multiplyTest() {
        int result = cal.multiply(2,3);
        assertEquals(6, result);
    }

    @Test
    public void divideTest() {
        int result = cal.divide(4,2);
        assertEquals(2, result);
    }

    @Test
    public void operateTest() {
        int result = cal.operate("+", 1, 3);
        assertEquals(4, result);
        result = cal.operate("-", 1, 3);
        assertEquals(-2, result);
        result = cal.operate("*", 1, 3);
        assertEquals(3, result);
        result = cal.operate("/", 4, 2);
        assertEquals(2, result);
    }
}