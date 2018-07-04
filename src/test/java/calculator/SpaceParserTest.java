package calculator;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SpaceParserTest {

    private SpaceParser parser;

    @Before
    public void setUp() {
        parser = new SpaceParser();
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseNullInput() {
        parser.parse(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseEmptyInput() {
        parser.parse("");
    }


    @Test
    public void extractOperatorsTest() {
        List<String> operators = parser.extractOperators(Arrays.asList("2", "+", "4"));
        assertThat(operators).isEqualTo(Arrays.asList("+"));
    }

    @Test
    public void extractOperandsTest() {
        List<Integer> operands = parser.extractOperands(Arrays.asList("2", "+", "4"));
        assertThat(operands).isEqualTo(Arrays.asList(2, 4));
    }
}