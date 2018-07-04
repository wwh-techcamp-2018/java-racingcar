package calculator.string.adder;


import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {
    private StringAddCalculator stringAddCalculator;
    @Before
    public void setUp() throws Exception {
        stringAddCalculator = new StringAddCalculator();
    }

    @Test
    public void sumTest() {
        assertThat(stringAddCalculator.sum(Arrays.asList(2, 3, 4))).isEqualTo(9);
        assertThat(stringAddCalculator.sum(Arrays.asList(2))).isEqualTo(2);
    }
}