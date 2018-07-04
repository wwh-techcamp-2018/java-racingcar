package calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    public void findDelimeter() {
        String text = "//&/n1&3";
        assertThat(StringCalculator.findDelimeter(text))
                .contains("&")
                .contains("1&3")
                .doesNotContain(",|:");
        text = "1,2,3";
        assertThat(StringCalculator.findDelimeter(text))
                .contains(",|:")
                .contains(text);
        text = "//#/n1#3#5";
        assertThat(StringCalculator.findDelimeter(text))
                .contains("#")
                .contains("1#3#5")
                .doesNotContain(",|:");
    }

    @Test
    public void splitDelimeter() {
        String str = "1,2:3";
        String delimiter = ",|:";
        int[] nums = StringCalculator.split(new String[] {delimiter, str});
        assertThat(nums)
                .contains(1)
                .contains(2)
                .doesNotContain(5);

        str = "1&3&5";
        delimiter = "&";
        nums = StringCalculator.split(new String[] {delimiter, str});
        assertThat(nums)
                .contains(1)
                .contains(3)
                .doesNotContain(6);
    }

    @Test
    public void convertToInt() {
        String[] stringNumbers = {"1", "2", "3"};
        assertThat(StringCalculator.convertToInt(stringNumbers))
                .contains(1)
                .contains(2)
                .doesNotContain(6);
    }

    @Test(expected = RuntimeException.class)
    public void checkNoMinusTest() {
        String [] nums = {"-1", "2", "3"};
        StringCalculator.convertToInt(nums);
    }

    @Test(expected = RuntimeException.class)
    public void checkNoCharTest() {
        String [] nums = {"&", "2", "3"};
        StringCalculator.convertToInt(nums);
    }

    @Test
    public void addTest() {
        int [] nums = {1, 2, 3};
        assertThat(StringCalculator.add(nums)).isEqualTo(6);
    }
}
