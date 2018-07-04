package calculator.plus;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    public void parseBasic() {
        assertThat(Calculator.parse("1,2:3"))
                .contains(1)
                .contains(2)
                .contains(3);
    }

    @Test
    public void parseCustom() {
        assertThat(Calculator.parse("//;\n1;2;3"))
                .contains(1)
                .contains(2)
                .contains(3);
    }

    @Test(expected = RuntimeException.class)
    public void negativeInput() {
        assertThat(Calculator.parse("//;\n-1;2;3"))
                .contains(1)
                .contains(2)
                .contains(3);
    }

    @Test(expected = RuntimeException.class)
    public void characterInput() {
        assertThat(Calculator.parse("a,2:3"))
                .contains(1)
                .contains(2)
                .contains(3);
    }

    @Test(expected = RuntimeException.class)
    public void characterDelimeter() {
        assertThat(Calculator.parse("7,9?8"))
                .contains(1)
                .contains(2)
                .contains(3);
    }

    @Test
    public void constructorBlank() {
        Calculator calculator = new Calculator("");
        assertThat(calculator.getOperandsSize()).isEqualTo(0);
    }

    @Test(expected = NullPointerException.class)
    public void constructorNull() {
        Calculator calculator = new Calculator(null);
        assertThat(calculator.getOperandsSize()).isEqualTo(0);
    }

    @Test
    public void calculate() {
        Calculator calculator = new Calculator("//@\n5@110@37");
        assertThat(calculator.calculate()).isEqualTo(152);
    }

    @Test
    public void calculateBlank() {
        Calculator calculator = new Calculator("");
        assertThat(calculator.calculate()).isEqualTo(0);
    }
}
