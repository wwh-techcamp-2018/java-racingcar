package string.calculator.plus;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class NumberFactoryTest {

    private List<Integer> numbers;

    @Before
    public void setUp() throws Exception {
        numbers = new ArrayList<Integer>();
    }

    @Test
    public void getNumbers() {
        numbers = NumberFactory.getNumbers("2,3:4");
        assertThat(numbers).contains(new Integer(2))
                .contains(new Integer(3))
                .contains(new Integer(4));
    }

    @Test
    public void plusNumbersTest() {
        assertThat(NumberFactory.plusNumbers(Arrays.asList(2, 3, 4))).isEqualTo(9);
    }

    @Test
    public void aTest() {
        assertThat(InputStringFactory.isCustomIterator("//;\\n1;2;3")).isTrue();
    }

    @Test
    public void getNumbersWithCustomIterator() {
        numbers = NumberFactory.getNumbers("1;2;3", ";");
        assertThat(numbers).contains(1).contains(2).contains(3);
    }

    @Test(expected = RuntimeException.class)
    public void isIntegerTestWithString() {
        assertThat(NumberFactory.isInteger("a"));
    }

    @Test(expected = RuntimeException.class)
    public void isPositiveNumber() {
        assertThat(NumberFactory.isPositiveNumber(-3));
    }
}