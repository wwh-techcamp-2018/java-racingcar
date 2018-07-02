package calculator;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


public class StringParserTest {
    private StringParser stringParser;
    @Before
    public void setUp() throws Exception {
        stringParser = new StringParser();
    }

    @Test(expected = IllegalArgumentException.class)
    public void getInput() {
        stringParser.getInput("");
    }
}