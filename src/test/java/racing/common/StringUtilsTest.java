package racing.common;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilsTest {

    @Test
    public void createDash() {
        assertThat(StringUtils.createDash(4)).isEqualTo("----");
    }
}