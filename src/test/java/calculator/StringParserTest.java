package calculator;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class StringParserTest {

    @Test (expected = IllegalArgumentException.class)
    public void parseNullInput() {
        new StringParser(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void parseEmptyInput() {
        new StringParser("");
    }

    @Test
    public void getOperators() {
        StringParser parser = new StringParser("2 + 3");

        List<String> expected = Arrays.asList("+");
        List<String> actual = parser.getOperators();

        assertThat(expected, is(actual));
    }

    @Test
    public void getOperands() {
        StringParser parser = new StringParser("2 + 3");

        List<Integer> expected = Arrays.asList(2, 3);
        List<Integer> actual = parser.getOperands();

        assertThat(expected, is(actual));
    }
}