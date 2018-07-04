package calculator.string.adder;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class SpliterFactoryTest {

    @Test
    public void createSpliter() {
        assertThat(SpliterFactory.createSpliter("//;N1;2;3")).isInstanceOf(CustomSpliter.class);
        assertThat(SpliterFactory.createSpliter("1;2;3")).isInstanceOf(DefaultSpliter.class);
    }
}