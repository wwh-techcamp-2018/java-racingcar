package calculator;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

public class CalcTest {

    @Test
    public void splitString() {
        List<Integer> nums = Calc.prepareElements("1,2:3");
        assertThat(nums).contains(1).contains(2).contains(3);
    }

    @Test
    public void splitStringNullEmpty() {
        assertThat(Calc.prepareElements("")).contains(0);
        assertThat(Calc.prepareElements(null)).contains(0);
    }

    @Test
    public void sumNumbers() {
        List<Integer> nums = Arrays.asList(1, 2, 3);
        assertEquals(6, Calc.sum(nums));
    }

    @Test
    public void useCustomSeparator() {
        Calc calc = new Calc("//;\n1;2;3");
        assertEquals(6, calc.resultSum());
    }

    @Test
    public void inputSingleValue() {
        Calc calc = new Calc("1");
        assertEquals(1, calc.resultSum());
    }

    @Test(expected = RuntimeException.class)
    public void minusValue() {
        Calc.prepareElements("-1,2,3");
    }
}



