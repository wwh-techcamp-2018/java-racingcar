package calculator;

import calculator.StringCalculator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalculatorTest {

    private StringCalculator sc;

    @Before
    public void setUp(){
        sc = new StringCalculator();
    }

    @Test
    public void isNumber(){
        assertEquals(sc.isNumber("-"),false);
        assertEquals(sc.isNumber("1"),true);

    }

    @Test
    public void calculator(){
        String case1 = "1 + 2 * 3";
        assertEquals(9, sc.stringCalculator(case1));

        String case2 = "1 + 2 / 3";
        assertEquals(1, sc.stringCalculator(case2));

        String case3 = "1 + 2 - 3";
        assertEquals(0, sc.stringCalculator(case3));

    }

    @Test(expected = IllegalArgumentException.class)
    public void calculatorException(){
        String case3 = "1 + 2 +";
        assertEquals(1, sc.stringCalculator(case3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullInputException(){
        String case3 = "";
        assertEquals(1, sc.stringCalculator(case3));
    }


}