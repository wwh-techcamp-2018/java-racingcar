package calculator.common;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class StringUtilsTest {

    @Test
    public void notEmptyInput() {
        String text = "";
        assertThat(StringUtils.notEmptyInput(text)).isEqualTo(false);
    }


}