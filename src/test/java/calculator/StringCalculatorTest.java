package calculator;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringCalculatorTest {
    StringCalculator cal;

    String[] inputZero = new String[]{};
    String[] inputLengthInvalid = new String[]{"1","+","2"," "};
    String[] inputValid = new String[]{"1","+","2","*","6","/","2"};

    String operandZero = "0";

    @Before
    public void setUp(){
        cal = new StringCalculator();

    }
    @Test
    public void callOperator(){
        String inputT = "3 * 5";
       assertEquals(15,  cal.callOperator(3, "*","5"));
    }
    //isValidate
    @Test
    public void isValid(){
        assertFalse(cal.isValidate(inputZero));
        assertFalse(cal.isValidate(inputLengthInvalid));
        assertTrue(cal.isValidate(inputValid));
    }
    //isValidateOperator
    @Test
    public void isValidateOperator(){
        assertFalse(cal.isValidateOperator("a","1"));
        assertFalse(cal.isValidateOperator("*", "a"));
        assertTrue(cal.isValidateOperator("*", "1"));
    }
    //isNumber
    @Test
    public void isNumber(){
        assertFalse(cal.isNumber("*"));
        assertFalse(cal.isNumber("Z"));
        assertTrue(cal.isNumber("023"));
        assertTrue(cal.isNumber("234"));
    }
    @Test (expected =  IllegalArgumentException.class)
    public void divideByZero(){
        Divider divider = new Divider();
        divider.operate(1,0);
    }
    //calculate
    @Test (expected =  IllegalArgumentException.class)
    public void calculate길이0(){
        cal.calculate( "");
    }
    @Test (expected =  IllegalArgumentException.class)
    public void calculate입력이연산자로끝(){
        cal.calculate( "1 + 2 +");
    }
    @Test
    public void calculateValid(){
        assertEquals( 6, cal.calculate( "1 + 2 * 5 - 3 / 2"));
    }
}
