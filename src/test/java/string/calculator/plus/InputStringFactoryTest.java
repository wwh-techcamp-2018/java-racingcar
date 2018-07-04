package string.calculator.plus;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputStringFactoryTest {
    @Test
    public void isCustomIteratorTest() {
        assertThat(InputStringFactory.isCustomIterator("//;\n1;2;3")).isTrue();
    }

    @Test
    public void setUpCustomIterator() {
        assertThat(InputStringFactory.getCustomIterator("//;\n1;2;3")).contains(";").contains("1;2;3");
    }
}