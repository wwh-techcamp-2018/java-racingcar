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
    public void calculatePlus() {
        int plusAnswer = sc.calculate("+", 1, 2);
        assertEquals(plusAnswer, 3);
    }

    @Test
    public void calculateMinus() {
        int substractAnswer = sc.calculate("-", 1, 2);
        assertEquals(substractAnswer, -1);
    }

    @Test
    public void calculateMultiply() {
        int multiplyAnswer = sc.calculate("*", 1, 2);
        assertEquals(multiplyAnswer, 2);
    }

    @Test
    public void calculateDivide() {
        int divideAnswer = sc.calculate("/", 1, 1);
        assertEquals(divideAnswer, 1);
    }

    @Test
    public void parseInt() {
        int ex = sc.parseInt("5");
        assertEquals(ex, 5);
    }

    @Test
    public void isBlank() {
        boolean ex = sc.isBlank("test");
        assertEquals(ex, true);
    }

    @Test
    public void calAnswer() {
        String s = "2 + 3 * 4 / 2";
        int answer = sc.calAnswer(s);
        assertEquals(answer, 10);
    }
}