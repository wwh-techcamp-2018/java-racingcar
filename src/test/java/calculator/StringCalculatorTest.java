package calculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalculatorTest {

    private StringCalculator sc;

    @Before
    public void setUp() throws Exception {
        sc = new StringCalculator();
    }

    @Test
    public void calculate() {
        int plusAnswer = sc.calculate("+",1,2);
        assertEquals(plusAnswer, 3);
        int substractAnswer = sc.calculate("-",1,2);
        assertEquals(substractAnswer, -1);
        int multiplyAnswer = sc.calculate("*",1,2);
        assertEquals(multiplyAnswer, 2);
        int divideAnswer = sc.calculate("/",1,1);
        assertEquals(divideAnswer, 1);
    }

    @Test
    public void parseInt(){
        int ex = sc.parseInt("5");
        assertEquals(ex, 5);
    }

    @Test
    public void isNullString() {
        boolean ex = sc.isNullString("test");
        assertEquals(ex, true);
    }

    @Test
    public void calAnswer() {
        String s = "2 + 3 * 4 / 2";
        int answer = sc.calAnswer(s);
        assertEquals(answer, 10);
    }
}