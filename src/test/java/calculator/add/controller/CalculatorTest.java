package calculator.add.controller;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void calculateBasic() {
        assertThat(calculator.calculate(calculator.getNumbers("1,2,3"))).isEqualTo(6);
    }

    @Test
    public void calculateBasicMix() {
        assertThat(calculator.calculate(calculator.getNumbers("1,2:3"))).isEqualTo(6);
    }

    @Test
    public void calculateCustom() {
        assertThat(calculator.calculate(calculator.getNumbers("//'\n1'2'3"))).isEqualTo(6);
    }

    @Test
    public void checkEmpty() {
        assertThat(calculator.calculate(calculator.getNumbers(" "))).isEqualTo(0);
    }

    @Test
    public void checkNull() {
        assertTrue(calculator.checkException(null));
    }

    @Test (expected = RuntimeException.class)
    public void checkExceptionMinus() {
        assertThat(calculator.calculate(calculator.getNumbers("-1,2,3")));
    }

    @Test (expected = RuntimeException.class)
    public void checkExceptionSpecial() {
        assertThat(calculator.calculate(calculator.getNumbers("*,2,3")));
    }

    @Test
    public void getNumbers() {
        String[] numbers = {"1", "2", "3"};
        assertArrayEquals(numbers, calculator.getNumbers("//'\n1'2'3"));
    }
}
