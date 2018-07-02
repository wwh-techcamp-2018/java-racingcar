package calculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void parse() {
        String[] arr = Calculator.parse("2 + 3 * 4");
        assertEquals(arr[0],"2");
        assertEquals(arr[1],"+");
        assertEquals(arr[2],"3");
        assertEquals(arr[3],"*");
        assertEquals(arr[4],"4");
    }

    @Test
    public void plus() {
        String[] arr = {"2", "+", "3"};
        assertEquals(5, Calculator.calculate(arr));
    }

    @Test
    public void minus() {
        String[] arr = {"2", "-", "4"};
        assertEquals(-2, Calculator.calculate(arr));
    }

    @Test
    public void multiple() {
        String[] arr = {"-2", "*", "3"};
        assertEquals(-6, Calculator.calculate(arr));
    }

    @Test
    public void divide() {
        String[] arr = {"4", "/", "3"};
        assertEquals(1, Calculator.calculate(arr));
    }

    @Test (expected = NumberFormatException.class)
    public void calculateNotNumber() {
        String[] arr = {"2", "+", "a"};
        Calculator.calculate(arr);
    }

    @Test (expected = ArithmeticException.class)
    public void calculateNotOperator() {
        String[] arr = {"2", ")", "3"};
        Calculator.calculate(arr);
    }

    @Test (expected = IllegalArgumentException.class)
    public void inputStringSpace() {
        Calculator.parse(" ");
    }

    @Test (expected = IllegalArgumentException.class)
    public void inputStringNull() {
        Calculator.parse(null);
    }

}