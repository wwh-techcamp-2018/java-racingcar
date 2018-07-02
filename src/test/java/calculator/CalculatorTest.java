package calculator;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    private Calculator cal;

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
    public void multiply() {
        assertThat(cal.multiply(2, 3)).isEqualTo(6);
    }

    @Test
    public void divide() {
        assertThat(cal.divide(4, 2)).isEqualTo(2);
    }
}