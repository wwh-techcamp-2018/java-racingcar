package calculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
public class CalculatorTest {

    Calculator cal;

    @Before
    public void setUp(){
        cal = new Calculator();
    }

    @Test
    public void plus() {
        assertEquals(5, cal.plus(2,3));
        assertThat(5, is(cal.plus(2,3)));

    }

    @Test
    public void minus(){
        int result = cal.minus(2,3);
        assertEquals(-1, result);
    }

    @Test
    public void mul(){
        int result = cal.mul(2,3);
        assertEquals(6, result);
    }


}