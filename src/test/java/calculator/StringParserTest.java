package calculator;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


public class StringParserTest {
    private StringParser stringParser;
    @Before
    public void setUp() {
        stringParser = new StringParser();
    }

    @Test(expected = IllegalArgumentException.class)
    public void getInput() {
        stringParser.setInput("");
    }

    @Test
    public void nextNum() {
        stringParser.setInput("2 + 3");
        assertThat(stringParser.nextNum()).isEqualTo(2);
        assertThat(stringParser.nextNum()).isEqualTo(3);
    }

    @Test
    public void nextOperator() {
        stringParser.setInput("2 + 3 * 5");
        assertThat(stringParser.nextOperator()).isEqualTo("+");
        assertThat(stringParser.nextOperator()).isEqualTo("*");
    }

    @Test
    public void setInput() {
        assertThat(stringParser.setInput("2 + 3 + 5")).isEqualTo(new String[]{"2","+", "3","+", "5"});
    }
}