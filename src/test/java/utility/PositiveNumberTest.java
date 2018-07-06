package utility;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class PositiveNumberTest {

    @Test (expected = IllegalArgumentException.class)
    public void negativeNumber() {
        PositiveNumber.of(-1);
    }

    @Test (expected = RuntimeException.class)
    public void alphabet() {
        PositiveNumber.of("a");
    }

    @Test
    public void increment() {
        assertThat(PositiveNumber.of(1).increment()).isEqualTo(PositiveNumber.of(2));
    }

    @Test
    public void toInt() {
        assertThat(PositiveNumber.of(1).toInt()).isEqualTo(1);
    }

}