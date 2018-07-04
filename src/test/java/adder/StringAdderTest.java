package adder;


import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringAdderTest {

    private StringAdder stringAdder;

    @Before
    public void setUp() throws Exception {
        stringAdder = new StringAdder(new DelimiterParser());
    }


    @Test
    public void addWithOnlyComma() {
        assertThat(stringAdder.add("1,2,3")).isEqualTo(6);
    }


    @Test
    public void addWithOnlyColon() {
        assertThat(stringAdder.add("1:2:3")).isEqualTo(6);
    }

    @Test
    public void add() {
        assertThat(stringAdder.add("1,2:3")).isEqualTo(6);
        assertThat(stringAdder.add("1,2:4")).isEqualTo(7);
    }

    @Test(expected = RuntimeException.class)
    public void inputNegativeNumber() {
        stringAdder.add("1,-2:3");
    }

    @Test(expected = RuntimeException.class)
    public void inputNotIntegerCharacter() {
        stringAdder.add("1,a:3");
    }

    @Test
    public void addWithCustomDelimiter() {
        assertThat(stringAdder.add("//a\n1a2a3")).isEqualTo(6);
        assertThat(stringAdder.add("//b\n1b2b4")).isEqualTo(7);
    }

    @Test(expected = RuntimeException.class)
    public void negativeToInteger() {
        StringAdder.toPositiveInteger("-1");
    }

    @Test
    public void positiveToInteger() {
        assertThat(StringAdder.toPositiveInteger("1")).isOne();
    }

    @Test
    public void singleNumberString() {
        assertThat(stringAdder.add("1")).isOne();
    }

    @Test
    public void inputNull() {
        assertThat(stringAdder.add(null)).isZero();
    }

    @Test
    public void inputEmptyString() {
        assertThat(stringAdder.add("")).isZero();
    }
}
