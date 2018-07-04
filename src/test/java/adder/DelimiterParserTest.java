package adder;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DelimiterParserTest {

    private DelimiterParser parser;

    @Before
    public void setUp() throws Exception {
        parser = new DelimiterParser();
    }

    @Test
    public void parseByCustomDelimiter() {
        assertThat(parser.parse("//;\n1;1;1"))
                .hasSize(3)
                .containsOnly("1");
    }

    @Test
    public void parseByDefaultDelimiter() {
        assertThat(parser.parse("1,1:1"))
                .hasSize(3)
                .containsOnly("1");
    }
}
