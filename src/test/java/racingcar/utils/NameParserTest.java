package racingcar.utils;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NameParserTest {
    @Test
    public void nameParser() {
        assertThat(NameParser.parse("광일, 선영,유성 , 동희 "))
                .contains("광일")
                .contains("선영")
                .contains("유성")
                .contains("동희");
    }
}