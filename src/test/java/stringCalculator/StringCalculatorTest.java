package stringCalculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalculatorTest {

    private  StringCalculator cal;

    @Before
    public void setUp() throws Exception {

        cal = new StringCalculator();
    }

    @Test
    public void result() {
        int sum = cal.result("20 + 3 * 4 / 2");
        assertEquals(46,sum);
    }

    @Test
    public void calculate() {
        assertEquals(10,cal.calculate("+",5,5));

        assertEquals(0,cal.calculate("-",5,5));

        assertEquals(25,cal.calculate("*",5,5));

        assertEquals(1,cal.calculate("/",5,5));
    }

    @Test (expected =  IllegalArgumentException.class)
    public void calculateException(){
        assertEquals(10,cal.calculate("#",5,5));
    }

    @Test
    public void plus() {
        assertEquals(5,cal.plus(2,3));
    }


    @Test
    public void minus() {
        assertEquals(-1,cal.minus(2,3));
    }


    @Test
    public void div() {
        assertEquals(0,cal.div(2,3));
    }


    @Test
    public void multi() {
        assertEquals(6,cal.multi(2,3));
    }


}