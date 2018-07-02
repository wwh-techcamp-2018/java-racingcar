package calculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    // test간의 dependency가 있으면 안된다.
    // test의 독립적 구현 중요 !_!
    // before -> test -> after

    Calculator cal;

    @Before
    public void setUp() throws Exception {
        cal = new Calculator();
    }

    @Test
    public void plus() {
        assertEquals(5, cal.plus(2, 3));
    }

    @Test
    public void minus() {
        assertEquals(-1, cal.minus(2, 3));
    }

    @Test
    public void calculate() {
        assertEquals(10, cal.calculate("2 + 3 * 4 / 2"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void calculateErrorCase() {
        cal.calculate("qq ^ 0");
    }

}