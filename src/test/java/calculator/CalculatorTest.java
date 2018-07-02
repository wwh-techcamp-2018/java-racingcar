package calculator;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator cal;

    @Before
    public void setUp() throws Exception {

        cal = new Calculator();
    }

    @Test
    public void plus() {

        assertEquals(5,cal.plus(2,3));
    }

    @Test
    public void minus() {
        Calculator cal  = new Calculator();
        int result = cal.minus(2,3);
        assertEquals(-1,result);
    }

}