package calculator.string.adder;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class SpliterTest {

    private Spliter spliter = new DefaultSpliter();
    private Spliter customSpliter = new CustomSpliter(";");


    @Test
    public void defaultExtractNums() {
        List<Integer> nums = spliter.extractNums("2:3,4,5");
        assertThat(nums)
                .contains(2)
                .contains(3)
                .contains(4)
                .contains(5);
        assertThat(spliter.extractNums("")).containsOnlyOnce(0);
        assertThat(spliter.extractNums(null)).containsOnlyOnce(0);
        assertThat(spliter.extractNums("5")).containsOnlyOnce(5);

    }

    @Test
    public void customExtractNums() {
        List<Integer> nums = customSpliter.extractNums("//;N2;3;4;5");
        assertThat(nums)
                .contains(2)
                .contains(3)
                .contains(4)
                .contains(5);
        assertThat(customSpliter.extractNums("")).containsOnlyOnce(0);
        assertThat(customSpliter.extractNums("5")).containsOnlyOnce(5);

    }

    @Test(expected = RuntimeException.class)
    public void extractNumsRuntimeExceptionTest() {
        spliter.extractNums("-1:-3,5");
    }
}