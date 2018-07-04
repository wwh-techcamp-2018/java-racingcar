package sum;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SumCalculatorTest {
    @Test
    public void sumCalculate() {
        int result = SumCalculator.calculate(new int[]{1, 2, 3});
        assertThat(result).isEqualTo(6);
    }
}
